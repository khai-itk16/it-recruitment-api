package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.EmployerResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerResumeRepository extends JpaRepository<EmployerResumeEntity, Integer> {
}
