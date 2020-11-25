package com.itrecruitmentapi.controller.image;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrecruitmentapi.controller.image.DTO.ImageDTO;
import com.itrecruitmentapi.controller.image.exception.ImageIsNotUpload;
import com.itrecruitmentapi.controller.image.exception.JsonImageIsNotConvert;
import com.itrecruitmentapi.service.ImageService;
import com.itrecruitmentapi.service.ImageStorageService;
import com.itrecruitmentapi.shared.ResponseMessage;
import com.itrecruitmentapi.shared.model.FileInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController extends ResponseEntityExceptionHandler {
    private final ImageStorageService imageStorageService;
    private final ImageService imageService;
    private final ImageMapper imageMapper;

    @PostMapping()
    public ResponseEntity<List<ImageDTO>>
        uploadFiles(@RequestParam("files") MultipartFile[] files,
                    @RequestParam("jsonImageDTOs") String jsonImageDTOs) {

        ObjectMapper mapper = new ObjectMapper();
        List<ImageDTO> imageDTOs;

        try {
            imageDTOs = Arrays.asList(mapper.readValue(jsonImageDTOs, ImageDTO[].class));
            System.out.println(imageDTOs);
            List<String> fileNames = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                String fileName = this.imageStorageService.save(file);
                fileNames.add(fileName);
            });

            for (int i = 0; i < imageDTOs.size(); i++) {
                if(!imageDTOs.get(i).getImageName().equals("")) {
                    this.imageStorageService.delete(imageDTOs.get(i).getImageName());
                }
                imageDTOs.get(i).setImageName(fileNames.get(i));
            }
        } catch (JsonProcessingException e) {
            throw new JsonImageIsNotConvert();
        } catch (Exception e) {
            throw new ImageIsNotUpload();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.imageMapper.toImageDTOs(
                        this.imageService.addImages(
                                this.imageMapper.toImageEntities(imageDTOs)))
        );
    }

    @GetMapping()
    public ResponseEntity<List<FileInfo>> getListImages() {
        List<FileInfo> fileInfos = imageStorageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(ImageController.class, "getFile", path.getFileName().toString()).build().toString();
            return new FileInfo(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = imageStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @DeleteMapping()
    public ResponseEntity<ResponseMessage> deleteFile(@RequestParam(name = "imageId") int imageId,
                                                      @RequestParam(name = "imageName") String imageName) {
        this.imageStorageService.delete(imageName);
        this.imageService.deleteImage(imageId);
        return  ResponseEntity.ok(new ResponseMessage("delete success experience with id: " + imageId));
    }
}