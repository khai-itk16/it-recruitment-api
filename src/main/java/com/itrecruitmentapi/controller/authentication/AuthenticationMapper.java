package com.itrecruitmentapi.controller.authentication;

import com.itrecruitmentapi.controller.authentication.DTO.RegisterDTO;
import com.itrecruitmentapi.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthenticationMapper {
    @Mapping(source = "registerDTO.status", target = "status", defaultValue = "ACTIVE")
    AccountEntity toAccountEntity(RegisterDTO registerDTO);
}
