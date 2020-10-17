package com.itrecruitmentapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidate_resume")
public class CandidateResumeEntity implements Serializable {
    @Id
    private Integer accountId;

    @MapsId
    @OneToOne()
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    @Length(max = 50, message = "Name's candidate has max 50 character.")
    private String candidateName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Length(max = 11, message = "Phone must have less than or equal 11 character")
    private String phone;

    private int salaryExpect;

    @Column(columnDefinition = "TEXT")
    private String jobObjective;

    private int numYearExperience;

    @Column(columnDefinition = "TEXT")
    private String foreignLanguage;

    @Column(columnDefinition = "TEXT")
    private String achievement;

    @OneToOne()
    @JoinColumn(name = "job_position_id")
    private JobPositionEntity jobPositionEntity;

    @OneToOne()
    @JoinColumn(name = "job_type_id")
    private JobTypeEntity jobTypeEntity;

    @OneToMany(mappedBy = "candidateResumeEntity")
    private Collection<EducationEntity> educationEntities;

    @OneToMany(mappedBy = "candidateResumeEntity")
    private Collection<SkillEntity> skillEntities;

    @OneToMany(mappedBy = "candidateResumeEntity")
    private Collection<ExperienceEntity> experienceEntities;

    @OneToMany(mappedBy = "candidateResumeEntity", fetch = FetchType.LAZY)
    private Collection<JobSaveEntity> jobSaveEntities;

    @OneToMany(mappedBy = "candidateResumeEntity", fetch = FetchType.LAZY)
    private Collection<JobApplyEntity> jobApplyEntities;
}
