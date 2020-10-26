package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.AccountDTO;
import com.itrecruitmentapi.controller.image.ImageMapper;
import com.itrecruitmentapi.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring", uses = {ImageMapper.class})
public interface AccountMapper {
    @Mapping(source = "accountDTO.imageDTOs", target = "imageEntities")
    AccountEntity toAccountEntity(AccountDTO accountDTO);
    @Mapping(source = "accountEntity.imageEntities", target = "imageDTOs")
    AccountDTO toAccountDTO(AccountEntity accountEntity);
    List<AccountDTO> toAccountDTOs(List<AccountEntity> accountEntities);
}
