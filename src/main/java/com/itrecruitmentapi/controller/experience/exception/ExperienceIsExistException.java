package com.itrecruitmentapi.controller.experience.exception;

public class ExperienceIsExistException extends RuntimeException {
    public ExperienceIsExistException(int id) { super("Experience has existed with id: " + id); }
}
