package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.AccountDTO;
import com.itrecruitmentapi.entity.AccountEntity;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toAccountEntity(AccountDTO accountDTO);
    AccountDTO toAccountDTO(AccountEntity accountEntity);
    List<AccountDTO> toAccountDTOs(List<AccountEntity> accountEntities);
}
