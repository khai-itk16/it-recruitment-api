package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.account.exception.AccountIsExistsException;
import com.itrecruitmentapi.controller.account.exception.AccountIsNotExistsException;
import com.itrecruitmentapi.controller.account.exception.AccountNotFoundException;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.repository.AccountRepository;
import com.itrecruitmentapi.service.AccountService;
import com.itrecruitmentapi.shared.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<AccountEntity> getAllAccounts() {
        List<AccountEntity> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public AccountEntity getAccountById(int id) {
        AccountEntity accountEntity = this.accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException(id));
        return accountEntity;
    }

    @Override
    public AccountEntity addNewAccount(AccountEntity accountEntity) {
        Optional<AccountEntity> accountEntityFromDataBase = this.accountRepository.findByUsername(accountEntity.getUsername());
        if (accountEntityFromDataBase.isPresent()) {
            throw new AccountIsExistsException(accountEntityFromDataBase.get().getAccountId());
        }

        accountEntity.setPassword(new BCryptPasswordEncoder().encode(accountEntity.getPassword()));
        return this.accountRepository.save(accountEntity);
    }

    @Override
    public AccountEntity editAccount(AccountEntity accountEntity) {
        Optional<AccountEntity> accountEntityFromDataBase = this.accountRepository.findById(accountEntity.getAccountId());
        if (!accountEntityFromDataBase.isPresent()) {
            throw new AccountIsNotExistsException(accountEntity.getAccountId());
        }
        accountEntity = this.holdValueDefault(accountEntityFromDataBase.get(), accountEntity);
        this.accountRepository.save(accountEntity);
        return this.accountRepository.findById(accountEntity.getAccountId()).get();
    }

    private AccountEntity holdValueDefault(AccountEntity accountChange, AccountEntity account) {
        accountChange.setRoleEntities(account.getRoleEntities());
        accountChange.setAccountId(account.getAccountId());
        accountChange.setUsername(account.getUsername());
        accountChange.setEmail(account.getEmail());
        return accountChange;
    }

    @Override
    public void deleteAccountById(int id) {
        if (!this.accountRepository.existsById(id)) {
            throw new AccountIsNotExistsException(id);
        }
        this.accountRepository.deleteById(id);
    }

    @Override
    public List<AccountEntity> searchAccounts(String keySearch) {
        return null;
    }

    @Override
    public AccountEntity reverseStatusAccountById(int id) {
        if (!this.accountRepository.existsById(id)) {
            throw new AccountIsNotExistsException(id);
        }
        AccountEntity accountEntity = this.accountRepository.findById(id).get();
        accountEntity.setStatus(accountEntity.getStatus() == Status.ACTIVE ? Status.LOCK : Status.ACTIVE);
        this.accountRepository.save(accountEntity);
        return accountEntity;
    }
}
