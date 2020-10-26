package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.skill.exception.SkillIsNotExistException;
import com.itrecruitmentapi.entity.SkillEntity;
import com.itrecruitmentapi.repository.SkillRepository;
import com.itrecruitmentapi.service.AccountService;
import com.itrecruitmentapi.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;
    private final AccountService accountService;

    @Override
    public List<SkillEntity> getSkillByAccountId(int accountId) {
        this.accountService.getAccountById(accountId);
        return this.skillRepository.getSkillsByAccountId(accountId);
    }

    @Override
    public SkillEntity addSkill(SkillEntity skillEntity) {
        return this.skillRepository.save(skillEntity);
    }

    @Override
    public SkillEntity editSkill(SkillEntity skillEntity) {
        this.skillRepository.findById(skillEntity.getSkillId())
                .orElseThrow(() -> new SkillIsNotExistException(skillEntity.getSkillId()));
        return this.skillRepository.save(skillEntity);
    }

    @Override
    public void deleteSkillById(int id) {
        if (!this.skillRepository.existsById(id)) {
            throw new SkillIsNotExistException(id);
        }
        this.skillRepository.deleteById(id);
    }
}
