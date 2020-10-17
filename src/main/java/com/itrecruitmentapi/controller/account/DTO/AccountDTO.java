package com.itrecruitmentapi.controller.account.DTO;

import com.itrecruitmentapi.entity.AddressEntity;
import com.itrecruitmentapi.entity.RoleEntity;
import com.itrecruitmentapi.shared.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
    private int accountId;

    @NotBlank(message = "username can't be blank")
    @NotNull
    private String username;

    private Set<RoleEntity> roleEntities;

    @NotNull
    @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Email not match")
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;

    private AddressEntity addressEntity;

}
