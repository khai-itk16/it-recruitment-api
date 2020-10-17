package com.itrecruitmentapi.controller.skill.exception;

public class SkillIsExistException extends RuntimeException {
    public SkillIsExistException(int id) { super("Skill has existed with id: " + id); }
}
