package com.itrecruitmentapi.controller.experience.exception;

public class ExperienceIsNotExistException extends RuntimeException {
    public ExperienceIsNotExistException(int id) { super("Experience is not found with id: " + id); }
}
