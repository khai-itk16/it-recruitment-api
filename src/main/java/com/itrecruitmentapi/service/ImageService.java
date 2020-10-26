package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.ImageEntity;

import java.util.List;

public interface ImageService {
    List<ImageEntity> addImages(List<ImageEntity> imageEntities);
    void deleteImage (int id);
}
