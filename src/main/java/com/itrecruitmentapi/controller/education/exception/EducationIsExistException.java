package com.itrecruitmentapi.controller.education.exception;

public class EducationIsExistException extends  RuntimeException {
    public EducationIsExistException(int id) { super("Education has existed with id: " + id); }
}
