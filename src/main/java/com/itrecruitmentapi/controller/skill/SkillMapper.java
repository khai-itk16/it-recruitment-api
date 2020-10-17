package com.itrecruitmentapi.controller.skill;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.skill.DTO.SkillDTO;
import com.itrecruitmentapi.entity.SkillEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { CandidateMapper.class })
public interface SkillMapper {
    @Mapping(source = "skillDTO.candidateDTO", target = "candidateResumeEntity")
    SkillEntity toSkillEntity(SkillDTO skillDTO);
    SkillDTO toSkillDTO(SkillEntity skillEntity);
    List<SkillDTO> toSkillDTOs(List<SkillEntity> skillEntities);
}
