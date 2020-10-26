package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.EmployerResumeEntity;

public interface EmployerResumeService {
    EmployerResumeEntity getEmployerById(int id);
    EmployerResumeEntity updateEmployerResume(EmployerResumeEntity employerResumeEntity);
}
