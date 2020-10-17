package com.itrecruitmentapi.controller.account.exception;

public class AccountIsNotExistsException extends RuntimeException {
    public AccountIsNotExistsException(int id) {
        super("User is not exist with id: " + id);
    }
}
