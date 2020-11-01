package com.itrecruitmentapi.controller.job_save.exception;

public class JobSaveIsNotExistException extends RuntimeException {
    public JobSaveIsNotExistException(int id) {
        super("Job save is not exist with id: " + id);
    }
}
