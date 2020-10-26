package com.itrecruitmentapi.controller.account.DTO;

import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployerResumeDTO {
    private Integer accountId;

    private AccountDTO accountDTO;

    @Length(max = 150, message = "Name's employer has max-length = 150")
    private String employerName;

    @Length(max = 15)
    private String numMember;

    @Length(max = 20)
    private String workTime;

    private String overview;

    private String description;

    private Collection<JobPostDTO> jobPostDTOs;
}
