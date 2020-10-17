package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.controller.education.EducationMapper;
import com.itrecruitmentapi.controller.experience.ExperienceMapper;
import com.itrecruitmentapi.controller.skill.SkillMapper;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { AccountMapper.class, EducationMapper.class, ExperienceMapper.class, SkillMapper.class }, componentModel = "spring")
public interface CandidateMapper {
    @Mapping(source = "candidateDTO.accountDTO", target = "accountEntity")
    @Mapping(source = "candidateDTO.educationDTOs", target = "educationEntities")
    @Mapping(source = "candidateDTO.experienceDTOs", target = "experienceEntities")
    @Mapping(source = "candidateDTO.skillDTOs", target = "skillEntities")
    CandidateResumeEntity toCandidateResumeEntity(CandidateDTO candidateDTO);

    @Mapping(source = "candidateResumeEntity.accountEntity", target = "accountDTO")
    @Mapping(source = "candidateResumeEntity.educationEntities", target = "educationDTOs")
    @Mapping(source = "candidateResumeEntity.experienceEntities", target = "experienceDTOs")
    @Mapping(source = "candidateResumeEntity.skillEntities", target = "skillDTOs")
    CandidateDTO toCandidateDTO(CandidateResumeEntity candidateResumeEntity);
    List<CandidateDTO> toCandidateDTOs(List<CandidateResumeEntity> candidateResumeEntity);
}
