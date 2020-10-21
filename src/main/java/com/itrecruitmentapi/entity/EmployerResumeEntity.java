package com.itrecruitmentapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "employer_resume")
public class EmployerResumeEntity implements Serializable {
    public EmployerResumeEntity(int accountId) {
        this.accountId = accountId;
    }

    @Id
    private Integer accountId;

    @OneToOne()
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;

    @Length(max = 150, message = "Name's employer has max-length = 150")
    private String employerName;

    @Length(max = 15)
    private String numMember;

    @Length(max = 20)
    private String workTime;

    @Column(columnDefinition = "TEXT")
    private String overview;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "employerResumeEntity", cascade = CascadeType.ALL)
    private Collection<JobPostEntity> jobPostEntities;
}
