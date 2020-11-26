package com.itrecruitmentapi.controller.account;


import com.itrecruitmentapi.controller.account.DTO.AccountDTO;
import com.itrecruitmentapi.controller.account.DTO.PasswordDTO;
import com.itrecruitmentapi.entity.AccountEntity;
import com.itrecruitmentapi.service.AccountService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class AccountController {
    private final AccountMapper accountMapper;
    private final AccountService accountService;


    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.accountMapper.toAccountDTO(this.accountService.getAccountById(id)));
    }

    @Secured("ROLE_ADMIN")
    @GetMapping()
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        return  ResponseEntity.ok(this.accountMapper.toAccountDTOs(this.accountService.getAllAccounts()));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAllAccounts() {
        return ResponseEntity.ok(this.accountService.countAllAccounts());
    }

    @PutMapping()
    public ResponseEntity<AccountDTO> editAccount(@RequestBody @Validated AccountDTO accountDTO) {
        return ResponseEntity.ok(this.accountMapper.toAccountDTO(this.accountService
                .editAccount(this.accountMapper.toAccountEntity(accountDTO))));
    }

    @PutMapping("/change-password")
    public ResponseEntity<ResponseMessage> changePassword(@RequestBody @Validated PasswordDTO passwordDTO) {
        this.accountService.changePassWord(passwordDTO);
        return  ResponseEntity.ok(new ResponseMessage("change password success"));
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteAccount(@PathVariable("id") int id) {
        this.accountService.deleteAccountById(id);
        return  ResponseEntity.ok(new ResponseMessage("delete success account with id: " + id));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}/status")
    public ResponseEntity<ResponseMessage> changeStatus(@PathVariable("id") int id) {
        this.accountService.reverseStatusAccountById(id);
        return  ResponseEntity.ok(new ResponseMessage("change status success account with id: " + id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<AccountDTO>> searchAccounts(@RequestParam(name = "valueSearch") String valueSearch) {
        return ResponseEntity.ok(this.accountMapper.toAccountDTOs(this.accountService.searchAccounts(valueSearch)));
    }
}
