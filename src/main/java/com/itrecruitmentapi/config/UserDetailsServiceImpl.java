package com.itrecruitmentapi.config;

import com.itrecruitmentapi.controller.account.exception.AccountIsLockedException;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.entity.RoleEntity;
import com.itrecruitmentapi.repository.AccountRepository;
import com.itrecruitmentapi.shared.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AccountEntity> userOpt = accountRepository.findByUsername(username);

        if (userOpt.isPresent()) {

            AccountEntity accountEntity = userOpt.get();

            if(accountEntity.getStatus() == Status.LOCK) {
                throw new AccountIsLockedException();
            }

            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

            Set<RoleEntity> roles = accountEntity.getRoleEntities();

            for (RoleEntity role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }

            return new org.springframework.security.core.userdetails.User(
                    accountEntity.getUsername(), accountEntity.getPassword(), grantedAuthorities);

        }

        throw new UsernameNotFoundException("User not found");
    }
}
