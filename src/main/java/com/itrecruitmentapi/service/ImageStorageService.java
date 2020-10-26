package com.itrecruitmentapi.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface ImageStorageService {
    void init();

    String save(MultipartFile file);

    Resource load(String filename);

    void deleteAll();

    void delete(String filename);

    Stream<Path> loadAll();
}
