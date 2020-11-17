package com.itrecruitmentapi.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CandidateFilter {
    private Integer accountId;
    private String skillAndExperience;
}
