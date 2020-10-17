package com.itrecruitmentapi.repository;

import com.itrecruitmentapi.entity.CandidateResumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateResumeRepository extends JpaRepository<CandidateResumeEntity, Integer> {

}
