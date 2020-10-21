package com.itrecruitmentapi.controller.job_type;

import com.itrecruitmentapi.controller.job_type.DTO.JobTypeDTO;
import com.itrecruitmentapi.entity.JobTypeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobTypeMapper {
    JobTypeEntity toJobTypeEntity(JobTypeDTO jobTypeDTO);
    JobTypeDTO toJobTypeDTO(JobTypeEntity jobTypeEntity);
    List<JobTypeDTO> toJobTypeDTOs(List<JobTypeEntity> jobTypeEntities);
}
