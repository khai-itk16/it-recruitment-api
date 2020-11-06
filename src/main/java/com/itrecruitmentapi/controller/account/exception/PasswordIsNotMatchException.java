package com.itrecruitmentapi.controller.account.exception;

public class PasswordIsNotMatchException extends RuntimeException {
    public PasswordIsNotMatchException() { super("Password is not match"); }
}
