package com.itrecruitmentapi.controller.account.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(int id) {
        super("User id not found : " + id);
    }
}
