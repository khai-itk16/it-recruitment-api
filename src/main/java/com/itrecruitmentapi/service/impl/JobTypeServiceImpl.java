package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.entity.JobTypeEntity;
import com.itrecruitmentapi.repository.JobTypeRepository;
import com.itrecruitmentapi.service.JobTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobTypeServiceImpl implements JobTypeService {
    private final JobTypeRepository jobTypeRepository;


    @Override
    public List<JobTypeEntity> getAllJobTypes() {
        return this.jobTypeRepository.findAll();
    }
}
