package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.entity.ImageEntity;
import com.itrecruitmentapi.repository.ImageRepository;
import com.itrecruitmentapi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public List<ImageEntity> addImages(List<ImageEntity> imageEntities) {
        return this.imageRepository.saveAll(imageEntities);
    }

    @Override
    public void deleteImage(int id) {
        this.imageRepository.deleteById(id);
    }
}
