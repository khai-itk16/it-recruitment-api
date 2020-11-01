package com.itrecruitmentapi.controller.job_save;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.job_post.JobPostMapper;
import com.itrecruitmentapi.controller.job_save.DTO.JobSaveDTO;
import com.itrecruitmentapi.entity.JobSaveEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { JobPostMapper.class, CandidateMapper.class })
public interface JobSaveMapper {
    @Mapping(source = "jobSaveDTO.candidateDTO", target = "candidateResumeEntity")
    @Mapping(source = "jobSaveDTO.jobPostDTO", target = "jobPostEntity")
    JobSaveEntity toJobSaveEntity(JobSaveDTO jobSaveDTO);

    @Mapping(source = "jobSaveEntity.jobPostEntity", target = "jobPostDTO")
    JobSaveDTO toJobSaveDTO(JobSaveEntity jobSaveEntity);
    List<JobSaveDTO> toJobSaveDTOs(List<JobSaveEntity> jobSaveEntities);
}
