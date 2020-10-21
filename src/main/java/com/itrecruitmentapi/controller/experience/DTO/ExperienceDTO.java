package com.itrecruitmentapi.controller.experience.DTO;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExperienceDTO {
    private Integer experienceId;

    private String experienceName;

    @Length(max = 20)
    private String startTime;

    @Length(max = 20)
    private String endTime;

    private String description;

    private CandidateDTO candidateDTO;
}
