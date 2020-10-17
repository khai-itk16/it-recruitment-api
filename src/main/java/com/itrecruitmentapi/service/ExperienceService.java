package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.ExperienceEntity;

import java.util.List;

public interface ExperienceService {
    List<ExperienceEntity> getExperiencesByAccountId(int accountId);
    ExperienceEntity addExperience(ExperienceEntity experienceEntity);
    ExperienceEntity editExperience(ExperienceEntity experienceEntity);
    void deleteExperienceById(int id);
}
