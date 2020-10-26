package com.itrecruitmentapi.controller.image;


import com.itrecruitmentapi.controller.account.AccountMapper;
import com.itrecruitmentapi.controller.image.DTO.ImageDTO;
import com.itrecruitmentapi.entity.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { AccountMapper.class })
public interface ImageMapper {
    @Mapping(source = "imageEntity.avatar", target = "isAvatar")
    @Mapping(source = "imageEntity.banner", target = "isBanner")
    @Mapping(source = "imageEntity.thumbnail", target = "isThumbnail")
    ImageDTO toImageDTO(ImageEntity imageEntity);

    @Mapping(source = "imageDTO.accountDTO", target = "accountEntity")
    @Mapping(source = "imageDTO.avatar", target = "isAvatar")
    @Mapping(source = "imageDTO.banner", target = "isBanner")
    @Mapping(source = "imageDTO.thumbnail", target = "isThumbnail")
    ImageEntity toImageEntity(ImageDTO imageDTO);

    List<ImageDTO> toImageDTOs(List<ImageEntity> imageEntities);
    List<ImageEntity> toImageEntities(List<ImageDTO> imageDTOs);
}
