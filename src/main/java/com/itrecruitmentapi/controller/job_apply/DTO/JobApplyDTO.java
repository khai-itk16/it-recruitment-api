package com.itrecruitmentapi.controller.job_apply.DTO;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.entity.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobApplyDTO {
    private Integer jobApplyId;

    private Double matchPercent;

    private StatusEntity statusEntity;

    private CandidateDTO candidateDTO;

    private JobPostDTO jobPostDTO;
}
