package com.itrecruitmentapi.controller.authentication.DTO;


import com.itrecruitmentapi.entity.RoleEntity;
import com.itrecruitmentapi.shared.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

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
public class RegisterDTO {
    @Length(max = 50, message = "Username has max-length = 50")
    @NotBlank(message = "username can't be blank")
    @NotNull
    private String username;

    @Length(max = 100, message = "Password has max-length = 100")
    @NotBlank(message = "password can't be blank")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",
            message = "Password must be 8 characters including 1 uppercase letter, 1 lowercase letter and numeric characters")
    @NotNull
    private String password;

    @NotNull
    @Pattern(regexp = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$", message = "Email not match")
    private String email;

    private Set<RoleEntity> roleEntities;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
