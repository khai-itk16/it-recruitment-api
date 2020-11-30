package com.itrecruitmentapi.controller.image;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itrecruitmentapi.controller.image.DTO.ImageDTO;
import com.itrecruitmentapi.controller.image.exception.ImageIsNotUpload;
import com.itrecruitmentapi.controller.image.exception.JsonImageIsNotConvert;
import com.itrecruitmentapi.service.ImageService;
import com.itrecruitmentapi.service.ImageStorageService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            List<String> urlFiles = new ArrayList<>();
            Arrays.asList(files).stream().forEach(file -> {
                String urlFile = this.imageStorageService.save(file);
                urlFiles.add(urlFile);
            });

            for (int i = 0; i < imageDTOs.size(); i++) {
                String imageUrl = imageDTOs.get(i).getImageUrl();
                if(imageUrl != null && !imageUrl.equals("")) {
                    int lastIndexSlash = imageUrl.lastIndexOf("/");
                    String fileCloudId = imageUrl.substring(lastIndexSlash+1, lastIndexSlash+21);
                    this.imageStorageService.delete(fileCloudId);
                }
                imageDTOs.get(i).setImageUrl(urlFiles.get(i));
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

    @DeleteMapping()
    public ResponseEntity<ResponseMessage> deleteFile(@RequestParam(name = "imageId") int imageId,
                                                      @RequestParam(name = "imageUrl") String imageUrl) {
        System.out.println(imageUrl);
        if(!imageUrl.equals("")) {
            int lastIndexSlash = imageUrl.lastIndexOf("/");
            String fileCloudId = imageUrl.substring(lastIndexSlash+1, lastIndexSlash+21);
            this.imageStorageService.delete(fileCloudId);
        }
        this.imageService.deleteImage(imageId);
        return  ResponseEntity.ok(new ResponseMessage("delete success experience with id: " + imageId));
    }
}