package com.itrecruitmentapi.controller.skill.DTO;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkillDTO {
    private Integer skillId;

    private String skillName;

    private String description;

    private CandidateDTO candidateDTO;
}
