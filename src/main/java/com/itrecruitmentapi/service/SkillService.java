package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.SkillEntity;

import java.util.List;

public interface SkillService {
    List<SkillEntity> getSkillByAccountId(int accountId);
    SkillEntity addSkill(SkillEntity skillEntity);
    SkillEntity editSkill(SkillEntity skillEntity);
    void deleteSkillById(int id);
}
