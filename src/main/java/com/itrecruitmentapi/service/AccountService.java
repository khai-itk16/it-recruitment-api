package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();
    AccountEntity getAccountById(int id);
    AccountEntity addNewAccount(AccountEntity accountEntity);
    AccountEntity editAccount(AccountEntity accountEntity);
    void deleteAccountById(int id);
    List<AccountEntity> searchAccounts(String keySearch);
    AccountEntity reverseStatusAccountById(int id);
}
