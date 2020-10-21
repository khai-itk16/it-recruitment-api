package com.itrecruitmentapi.controller.job_position;

import com.itrecruitmentapi.controller.job_position.DTO.JobPositionDTO;
import com.itrecruitmentapi.entity.JobPositionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobPositionMapper {
    JobPositionEntity toJobPositionEntity(JobPositionDTO jobPositionDTO);
    JobPositionDTO toJobPositionDTO(JobPositionEntity jobPositionEntity);
    List<JobPositionDTO> toJobPositionDTOs(List<JobPositionEntity> jobPositionEntities);
}
