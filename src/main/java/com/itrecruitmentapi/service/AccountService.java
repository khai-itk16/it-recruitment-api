package com.itrecruitmentapi.service;

import com.itrecruitmentapi.controller.account.DTO.PasswordDTO;
import com.itrecruitmentapi.entity.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAllAccounts();
    AccountEntity getAccountById(int id);
    Long countAllAccounts();
    AccountEntity addNewAccount(AccountEntity accountEntity);
    AccountEntity editAccount(AccountEntity accountEntity);
    void changePassWord(PasswordDTO passwordDTO);
    void deleteAccountById(int id);
    List<AccountEntity> searchAccounts(String keySearch);
    AccountEntity reverseStatusAccountById(int id);
}
