package com.itrecruitmentapi.controller.job_position.exception;

public class JobPositionIsNotExistException extends RuntimeException {
    public JobPositionIsNotExistException(int id) { super("Job position is not exist with id: " + id); }
}
