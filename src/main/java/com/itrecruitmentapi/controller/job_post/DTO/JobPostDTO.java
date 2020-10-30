package com.itrecruitmentapi.controller.job_post.DTO;

import com.itrecruitmentapi.controller.account.DTO.EmployerResumeDTO;
import com.itrecruitmentapi.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JobPostDTO {
    private Integer jobPostId;

    @Length(max = 20, message = "Mã code có độ dài tối đa 20 ký tự")
    private String jobCode;

    private int numYearExperience;

    private String jobTitle;

    private String jobDescription;

    private String jobRequire;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createPostTime;

    @Temporal(TemporalType.DATE)
    private Date expirePostTime;

    private JobTypeEntity jobTypeEntity;

    private JobPositionEntity jobPositionEntity;

    private StatusEntity statusEntity;

    private EmployerResumeDTO employerResumeDTO;

//    private Collection<JobSaveEntity> jobSaveEntities;

//    private Collection<JobApplyEntity> jobApplyEntities;
}
