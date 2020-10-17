package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.account.exception.AccountIsNotExistsException;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.repository.AccountRepository;
import com.itrecruitmentapi.repository.CandidateResumeRepository;
import com.itrecruitmentapi.service.CandidateResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidateResumeServiceImpl implements CandidateResumeService {

    public final CandidateResumeRepository candidateResumeRepository;
    public final AccountRepository accountRepository;

    @Override
    public CandidateResumeEntity addCandidateInfor(CandidateResumeEntity candidateResumeEntity) {
        int id = candidateResumeEntity.getAccountEntity().getAccountId();
        AccountEntity accountEntity = this.accountRepository.findById(id).orElseThrow(() ->
                new AccountIsNotExistsException(id));
        accountEntity.setAddressEntity(candidateResumeEntity.getAccountEntity().getAddressEntity());
        this.accountRepository.save(accountEntity);
        return this.candidateResumeRepository.save(candidateResumeEntity);
    }

    @Override
    public CandidateResumeEntity getCandidateById(int id) {
        Optional<CandidateResumeEntity> optionalCandidateResumeEntity = this.candidateResumeRepository.findById(id);
        if (!optionalCandidateResumeEntity.isPresent()) {
            throw new AccountIsNotExistsException(id);
        }
        return optionalCandidateResumeEntity.get();
    }
}

