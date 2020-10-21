package com.itrecruitmentapi.service;

import com.itrecruitmentapi.entity.CandidateResumeEntity;

public interface CandidateResumeService {
    CandidateResumeEntity updateCandidateInfor(CandidateResumeEntity candidateResumeEntity);
    CandidateResumeEntity getCandidateById(int id);
    CandidateResumeEntity updateCandidateResume(CandidateResumeEntity candidateResumeEntity);
}
