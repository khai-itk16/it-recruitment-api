package com.itrecruitmentapi.controller.job_post;

import com.itrecruitmentapi.controller.account.EmployerMapper;
import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.entity.JobPostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { EmployerMapper.class })
public interface JobPostMapper {
    @Mapping(source = "jobPostDTO.employerResumeDTO", target = "employerResumeEntity")
    JobPostEntity toJobPostEntity(JobPostDTO jobPostDTO);
    @Mapping(source = "jobPostEntity.employerResumeEntity", target = "employerResumeDTO")
    JobPostDTO toJobPostDTO (JobPostEntity jobPostEntity);
    List<JobPostDTO> toJobPostDTOs(List<JobPostEntity> jobPostEntities);
}
