package com.itrecruitmentapi.controller.authentication;


import com.itrecruitmentapi.config.TokenProvider;
import com.itrecruitmentapi.controller.account.AccountMapper;
import com.itrecruitmentapi.controller.account.DTO.AccountDTO;
import com.itrecruitmentapi.controller.account.exception.AccountIsLockedException;
import com.itrecruitmentapi.controller.authentication.DTO.AuthTokenDTO;
import com.itrecruitmentapi.controller.authentication.DTO.LoginDTO;
import com.itrecruitmentapi.controller.authentication.DTO.RegisterDTO;
import com.itrecruitmentapi.controller.authentication.exception.PasswordLoginFailedException;
import com.itrecruitmentapi.service.AccountService;
import com.itrecruitmentapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final TokenProvider jwtTokenUtil;
    private final AuthenticationMapper authenticationMapper;
    private final AccountMapper accountMapper;
    private final AccountService accountService;
    private final AuthService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthTokenDTO> login(@RequestBody @Validated LoginDTO login) {
        if (this.authenticationService.isHandleUsername(login.getUsername())) {
            try {
                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                login.getUsername(),
                                login.getPassword()
                        )
                );
                SecurityContextHolder.getContext().setAuthentication(authentication);
                final String token = jwtTokenUtil.generateToken(authentication);
                return ResponseEntity.ok(new AuthTokenDTO(token));
            } catch (Exception e) {
                if (e instanceof UsernameNotFoundException) {
                    throw new PasswordLoginFailedException();
                } else {
                    throw new AccountIsLockedException();
                }
            }
        }
        throw new UsernameNotFoundException("Login failed");
    }

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@RequestBody @Validated RegisterDTO registerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.accountMapper.toAccountDTO(this.accountService.addNewAccount(
                        this.authenticationMapper.toAccountEntity(registerDTO))));
    }
}
