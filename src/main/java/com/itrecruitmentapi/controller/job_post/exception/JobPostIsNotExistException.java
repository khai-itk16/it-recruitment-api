package com.itrecruitmentapi.controller.job_post.exception;

public class JobPostIsNotExistException extends RuntimeException {
    public JobPostIsNotExistException(int id) {
        super("Job post is not exist with id: " + id);
    }
}
