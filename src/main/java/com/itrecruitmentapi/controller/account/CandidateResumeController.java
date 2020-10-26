package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.service.CandidateResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/candidate")
public class CandidateResumeController {

    private final CandidateMapper candidateMapper;
    private final CandidateResumeService candidateResumeService;

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getAccountById(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.candidateMapper.toCandidateDTO(this.candidateResumeService.getCandidateById(id)));
    }

    @PutMapping("/self-infor")
    public ResponseEntity<CandidateDTO> updateCandidateInfor(@RequestBody @Validated CandidateDTO candidateDTO) {
        System.out.println(candidateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.candidateMapper.toCandidateDTO(this.candidateResumeService.updateCandidateInfor(
                        this.candidateMapper.toCandidateResumeEntity(candidateDTO))));
    }

    @PutMapping("/candidate-resume")
    public ResponseEntity<CandidateDTO> updateCandidateResume(@RequestBody @Validated CandidateDTO candidateDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.candidateMapper.toCandidateDTO(this.candidateResumeService.updateCandidateResume(
                        this.candidateMapper.toCandidateResumeEntity(candidateDTO))));
    }
}
