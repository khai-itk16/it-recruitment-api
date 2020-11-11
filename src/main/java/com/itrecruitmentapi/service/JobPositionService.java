package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.JobPositionEntity;

import java.util.List;

public interface JobPositionService {
    List<JobPositionEntity> getAllJobPositions();
    Long countAllJobPositions();
    JobPositionEntity addJobPosition(JobPositionEntity jobPositionEntity);
    JobPositionEntity editJobPosition(JobPositionEntity jobPositionEntity);
    void deleteJobPositionById(int id);
}
