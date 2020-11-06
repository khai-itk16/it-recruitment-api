package com.itrecruitmentapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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
@Table(name = "job_post")
public class JobPostEntity implements Serializable {
    public JobPostEntity(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;

    @Length(max = 20)
    private String jobCode;

    private int numYearExperience;

    private String jobTitle;

    @Column(columnDefinition = "TEXT")
    private String jobDescription;

    @Column(columnDefinition = "TEXT")
    private String jobRequire;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date createPostTime;
    
    @Temporal(TemporalType.DATE)
    private Date expirePostTime;

    @OneToOne()
    @JoinColumn(name = "job_type_id")
    private JobTypeEntity jobTypeEntity;

    @OneToOne()
    @JoinColumn(name = "job_position_id")
    private JobPositionEntity jobPositionEntity;

    @OneToOne()
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private EmployerResumeEntity employerResumeEntity;

    @OneToMany(mappedBy = "jobPostEntity")
    private Collection<JobSaveEntity> jobSaveEntities;

    @OneToMany(mappedBy = "jobPostEntity")
    private Collection<JobApplyEntity> jobApplyEntities;
}
