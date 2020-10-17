package com.itrecruitmentapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_post")
public class JobPostEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;

    private int numYearExprience;

    private String jobTitle;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne()
    @JoinColumn(name = "job_type_id")
    private JobTypeEntity jobTypeEntity;

    @OneToOne()
    @JoinColumn(name = "job_position_id")
    private JobPositionEntity jobPositionEntity;

    @OneToOne()
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    private EmployerResumeEntity employerResumeEntity;

    @OneToMany(mappedBy = "jobPostEntity", cascade = CascadeType.ALL)
    private Collection<JobSaveEntity> jobSaveEntities;

    @OneToMany(mappedBy = "jobPostEntity", cascade = CascadeType.ALL)
    private Collection<JobApplyEntity> jobApplyEntities;
}
