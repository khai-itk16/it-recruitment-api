package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.EmployerResumeDTO;
import com.itrecruitmentapi.entity.EmployerResumeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = { AccountMapper.class }, componentModel = "spring")
public interface EmployerMapper {
    @Mapping(source = "employerResumeDTO.accountDTO", target = "accountEntity")
    EmployerResumeEntity toEmployerResumeEntity(EmployerResumeDTO employerResumeDTO);
    @Mapping(source = "employerResumeEntity.accountEntity", target = "accountDTO")
    EmployerResumeDTO toEmployerResumeDTO(EmployerResumeEntity employerResumeEntity);
    List<EmployerResumeDTO> toEmployerResumeDTOs(List<EmployerResumeEntity> candidateResumeEntity);
}
