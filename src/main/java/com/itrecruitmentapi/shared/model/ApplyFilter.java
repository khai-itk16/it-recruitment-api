package com.itrecruitmentapi.shared.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApplyFilter {
    Integer jobPostId;
    String jobRequire;
    List<CandidateFilter> candidateFilters = new ArrayList<>();
}
