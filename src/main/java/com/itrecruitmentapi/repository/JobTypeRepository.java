package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.JobTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobTypeEntity, Integer> {
}
