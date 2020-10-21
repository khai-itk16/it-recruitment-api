package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.JobPositionEntity;

import java.util.List;

public interface JobPositionService {
    List<JobPositionEntity> getAllJobPositions();
}
