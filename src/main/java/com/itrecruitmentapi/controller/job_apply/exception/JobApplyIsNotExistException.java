package com.itrecruitmentapi.controller.job_apply.exception;

public class JobApplyIsNotExistException extends RuntimeException {
    public JobApplyIsNotExistException(int id) { super("Job apply is not exist with id: " + id); }
}
