package com.itrecruitmentapi.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {
    String save(MultipartFile file);
    void delete(String fileCloudId);

}
