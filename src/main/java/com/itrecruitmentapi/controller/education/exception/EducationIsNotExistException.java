package com.itrecruitmentapi.controller.education.exception;

public class EducationIsNotExistException extends RuntimeException {
    public EducationIsNotExistException(int id) {
        super("Education not found with id: " + id);
    }
}
