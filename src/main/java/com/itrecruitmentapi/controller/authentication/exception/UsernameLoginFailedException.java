package com.itrecruitmentapi.controller.authentication.exception;

public class UsernameLoginFailedException extends RuntimeException {
    public UsernameLoginFailedException() {
        super("Username login failed");
    }
}
