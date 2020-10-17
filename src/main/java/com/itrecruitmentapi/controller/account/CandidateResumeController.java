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

    public final CandidateMapper candidateMapper;
    public final CandidateResumeService candidateResumeService;

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getAccountById(@PathVariable("id") int id) {
        return ResponseEntity.ok(this.candidateMapper.toCandidateDTO(this.candidateResumeService.getCandidateById(id)));
    }

    @PostMapping("/self-infor")
    public ResponseEntity<CandidateDTO> addCandidateInfor(@RequestBody @Validated CandidateDTO candidateDTO) {
        System.out.println("========add new self infor candidate======");
        System.out.println(candidateDTO);
        System.out.println("========candidate resume entity======");
        System.out.println(this.candidateMapper.toCandidateResumeEntity(candidateDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.candidateMapper.toCandidateDTO(this.candidateResumeService.addCandidateInfor(
                        this.candidateMapper.toCandidateResumeEntity(candidateDTO))));
    }
}
