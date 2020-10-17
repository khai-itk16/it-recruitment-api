package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.EducationEntity;

import java.util.List;

public interface EducationService {
    EducationEntity addEducation(EducationEntity educationEntity);
    List<EducationEntity> getEducationsByAccountId(int accountId);
    EducationEntity editEducation(EducationEntity educationEntity);
    void deleteEducationById(int id);
}
