package com.itrecruitmentapi.controller.experience;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.experience.DTO.ExperienceDTO;
import com.itrecruitmentapi.entity.ExperienceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CandidateMapper.class })
public interface ExperienceMapper {
    @Mapping(source = "experienceDTO.candidateDTO", target = "candidateResumeEntity")
    ExperienceEntity toExperienceEntity(ExperienceDTO experienceDTO);
    ExperienceDTO toExperienceDTO (ExperienceEntity experienceEntity);
    List<ExperienceDTO> toExperienceDTOs(List<ExperienceEntity> experienceEntities);
}
