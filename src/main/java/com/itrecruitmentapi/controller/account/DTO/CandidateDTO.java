package com.itrecruitmentapi.controller.account.DTO;

import com.itrecruitmentapi.controller.education.DTO.EducationDTO;
import com.itrecruitmentapi.controller.experience.DTO.ExperienceDTO;
import com.itrecruitmentapi.controller.skill.DTO.SkillDTO;
import com.itrecruitmentapi.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDTO {
    private int accountId;

    private AccountDTO accountDTO;

    @Length(max = 50, message = "Name's candidate has max 50 character.")
    private String candidateName;

    private boolean sex;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Length(max = 11, message = "Phone must have less than or equal 11 character")
    private String phone;

    private int salaryExpect;

    private String jobObjective;

    private int numYearExperience;

    private String foreignLanguage;

    private String achievement;

    private JobPositionEntity jobPositionEntity;

    private JobTypeEntity jobTypeEntity;

    private Collection<EducationDTO> educationDTOs;

    private Collection<SkillDTO> skillDTOs;

    private Collection<ExperienceDTO> experienceDTOs;
}
