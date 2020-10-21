package com.itrecruitmentapi.controller.job_type.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobTypeDTO {
    private Integer jobTypeId;

    private String jobTypeName;
}
