package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.education.exception.EducationIsNotExistException;
import com.itrecruitmentapi.entity.EducationEntity;
import com.itrecruitmentapi.repository.EducationRepository;
import com.itrecruitmentapi.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;


    @Override
    public List<EducationEntity> getEducationsByAccountId(int accountId) {
        return this.educationRepository.getEducationsByAccountId(accountId);
    }

    @Override
    public EducationEntity addEducation(EducationEntity educationEntity) {
        return this.educationRepository.save(educationEntity);
    }

    @Override
    public EducationEntity editEducation(EducationEntity educationEntity) {
                this.educationRepository
                        .findById(educationEntity.getEducationId())
                        .orElseThrow(() -> new EducationIsNotExistException(educationEntity.getEducationId()));
        return this.educationRepository.save(educationEntity);
    }

    @Override
    public void deleteEducationById(int id) {
        if (!this.educationRepository.existsById(id)) {
            throw new EducationIsNotExistException(id);
        }
        this.educationRepository.deleteById(id);
    }


}
