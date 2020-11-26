package com.itrecruitmentapi.controller.account.exception;

public class AccountIsLockedException extends RuntimeException {
    public AccountIsLockedException() { super("Account is locked"); }
}
