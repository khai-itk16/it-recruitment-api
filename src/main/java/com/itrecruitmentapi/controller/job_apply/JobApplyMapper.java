package com.itrecruitmentapi.controller.job_apply;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.job_apply.DTO.JobApplyDTO;
import com.itrecruitmentapi.controller.job_post.JobPostMapper;
import com.itrecruitmentapi.entity.JobApplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { JobPostMapper.class, CandidateMapper.class })
public interface JobApplyMapper {
    @Mapping(source = "jobApplyDTO.candidateDTO", target = "candidateResumeEntity")
    @Mapping(source = "jobApplyDTO.jobPostDTO", target = "jobPostEntity")
    JobApplyEntity toJobApplyEntity(JobApplyDTO jobApplyDTO);

    JobApplyDTO toJobApplyDTO(JobApplyEntity jobApplyEntity);
    List<JobApplyDTO> toJobApplyDTOs(List<JobApplyEntity> jobApplyEntities);
}
