package com.itrecruitmentapi.service.impl;

import com.itrecruitmentapi.controller.authentication.exception.UsernameLoginFailedException;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.repository.AccountRepository;
import com.itrecruitmentapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    @Override
    public boolean isHandleUsername(String username) {
        Optional<AccountEntity> userEntity = this.accountRepository.findByUsername(username);
        if (!userEntity.isPresent()) {
            throw new UsernameLoginFailedException();
        }
        return true;
    }
}
