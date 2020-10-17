package com.itrecruitmentapi.controller.skill.exception;

public class SkillIsNotExistException extends RuntimeException {
    public SkillIsNotExistException(int id) { super("Skill is not found with id: " + id); }
}
