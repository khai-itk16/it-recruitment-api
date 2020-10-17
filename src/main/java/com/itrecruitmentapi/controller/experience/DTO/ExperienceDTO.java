package com.itrecruitmentapi.controller.experience.DTO;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDTO {
    private Integer experienceId;

    private String experienceName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    private String description;

    private CandidateDTO candidateDTO;
}
