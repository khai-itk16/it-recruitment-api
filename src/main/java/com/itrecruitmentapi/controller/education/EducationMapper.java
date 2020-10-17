package com.itrecruitmentapi.controller.education;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.education.DTO.EducationDTO;
import com.itrecruitmentapi.entity.EducationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CandidateMapper.class })
public interface EducationMapper {
    @Mapping(source = "educationDTO.candidateDTO", target = "candidateResumeEntity")
    EducationEntity toEducationEntity (EducationDTO educationDTO);

    EducationDTO toEducationDTO (EducationEntity educationEntity);
    List<EducationDTO> toEducationDTOs(List<EducationEntity> educationEntities);
}
