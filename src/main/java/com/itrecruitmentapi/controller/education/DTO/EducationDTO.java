package com.itrecruitmentapi.controller.education.DTO;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationDTO {
    private Integer educationId;

    @Length(max = 100)
    private String school;

    private boolean isDegree;

    @Temporal(TemporalType.DATE)
    private Date degreeTime;

    private String description;

    private CandidateDTO candidateDTO;
}
