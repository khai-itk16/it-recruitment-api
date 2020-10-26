package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.account.exception.AccountIsNotExistsException;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.EmployerResumeEntity;
import com.itrecruitmentapi.repository.AccountRepository;
import com.itrecruitmentapi.repository.EmployerResumeRepository;
import com.itrecruitmentapi.service.EmployerResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerResumeServiceImpl implements EmployerResumeService {
    private final EmployerResumeRepository employerResumeRepository;
    private final AccountRepository accountRepository;

    @Override
    public EmployerResumeEntity getEmployerById(int id) {
        Optional<EmployerResumeEntity> optionalEmployerResumeEntity = this.employerResumeRepository.findById(id);
        if (!optionalEmployerResumeEntity.isPresent()) {
            throw new AccountIsNotExistsException(id);
        }
        return optionalEmployerResumeEntity.get();
    }

    @Override
    public EmployerResumeEntity updateEmployerResume(EmployerResumeEntity employerResumeEntity) {
        int id = employerResumeEntity.getAccountId();
        if(!this.employerResumeRepository.existsById(id)) {
            throw new AccountIsNotExistsException(id);
        }
        AccountEntity accountEntity = this.accountRepository.findById(id).orElseThrow(() ->
                new AccountIsNotExistsException(id));
        accountEntity.setAddressEntity(employerResumeEntity.getAccountEntity().getAddressEntity());
        this.accountRepository.save(accountEntity);
        return this.employerResumeRepository.save(employerResumeEntity);
    }
}
