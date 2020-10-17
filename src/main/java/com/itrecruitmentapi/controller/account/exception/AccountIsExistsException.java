package com.itrecruitmentapi.controller.account.exception;

public class AccountIsExistsException extends RuntimeException {
    public AccountIsExistsException(int id) {
        super("User is exist with id: " + id);
    }
}
