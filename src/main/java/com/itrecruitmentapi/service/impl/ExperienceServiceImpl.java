package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.experience.exception.ExperienceIsExistException;
import com.itrecruitmentapi.controller.experience.exception.ExperienceIsNotExistException;
import com.itrecruitmentapi.entity.ExperienceEntity;
import com.itrecruitmentapi.repository.ExperienceRepository;
import com.itrecruitmentapi.service.AccountService;
import com.itrecruitmentapi.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    public final ExperienceRepository experienceRepository;
    public final AccountService accountService;

    @Override
    public List<ExperienceEntity> getExperiencesByAccountId(int accountId) {
        this.accountService.getAccountById(accountId);
        return this.experienceRepository.getExperiencesByAccountId(accountId);
    }

    @Override
    public ExperienceEntity addExperience(ExperienceEntity experienceEntity) {
        Optional<ExperienceEntity> optionalExperienceEntity =
                this.experienceRepository.findById(experienceEntity.getExperienceId());
        if (!optionalExperienceEntity.isPresent()) {
            throw new ExperienceIsExistException(experienceEntity.getExperienceId());
        }
        return this.experienceRepository.save(experienceEntity);
    }

    @Override
    public ExperienceEntity editExperience(ExperienceEntity experienceEntity) {
        this.experienceRepository.findById(experienceEntity.getExperienceId())
                .orElseThrow(() -> new ExperienceIsNotExistException(experienceEntity.getExperienceId()));
        return this.experienceRepository.save(experienceEntity);
    }

    @Override
    public void deleteExperienceById(int id) {
        if (!this.experienceRepository.existsById(id)) {
            throw new ExperienceIsNotExistException(id);
        }
        this.experienceRepository.deleteById(id);
    }
}
