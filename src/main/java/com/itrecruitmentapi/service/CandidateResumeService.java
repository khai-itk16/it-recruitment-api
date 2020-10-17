package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;

public interface CandidateResumeService {
    CandidateResumeEntity addCandidateInfor(CandidateResumeEntity candidateResumeEntity);
    CandidateResumeEntity getCandidateById(int id);
}
