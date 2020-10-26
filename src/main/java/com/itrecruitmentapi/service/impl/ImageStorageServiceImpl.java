package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.image.exception.FolderIsNotInitial;
import com.itrecruitmentapi.controller.image.exception.ImageIsNotLoad;
import com.itrecruitmentapi.controller.image.exception.ImageIsNotRead;
import com.itrecruitmentapi.controller.image.exception.ImageIsNotStore;
import com.itrecruitmentapi.service.ImageStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ImageStorageServiceImpl implements ImageStorageService {
    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new FolderIsNotInitial();
        }
    }

    @Override
    public String save(MultipartFile file) {
        try {
            long currentTime = System.currentTimeMillis();
            String fileName = file.getOriginalFilename().split("\\.")[0];
            String extension = "." + file.getOriginalFilename().split("\\.")[1];
            String fileStorePath = "";
            if(fileName.length() > 20) {
                fileStorePath  = fileName.substring(0,20) + currentTime + extension;
            } else {
                fileStorePath = fileName + currentTime + extension;
            }
            Files.copy(file.getInputStream(), this.root.resolve(fileStorePath));
            return fileStorePath;
        } catch (Exception e) {
            throw new ImageIsNotStore(e);
        }
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new ImageIsNotRead();
            }
        } catch (MalformedURLException e) {
            throw new ImageIsNotLoad(e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public void delete(String filename) {
        try {
            System.out.println(Files.deleteIfExists(Paths.get("uploads/" + filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new ImageIsNotLoad(e);
        }
    }
}
