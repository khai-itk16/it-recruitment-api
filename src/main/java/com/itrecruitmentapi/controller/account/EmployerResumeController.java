package com.itrecruitmentapi.controller.account;

import com.itrecruitmentapi.controller.account.DTO.EmployerResumeDTO;
import com.itrecruitmentapi.service.EmployerResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employer")
public class EmployerResumeController {
    private final EmployerMapper employerMapper;
    private final EmployerResumeService employerResumeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployerResumeDTO> getAccountById(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                this.employerMapper.toEmployerResumeDTO(
                        this.employerResumeService.getEmployerById(id)));
    }

    @PutMapping()
    public ResponseEntity<EmployerResumeDTO> updateEmployerResume(@RequestBody @Validated EmployerResumeDTO employerResumeDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.employerMapper.toEmployerResumeDTO(
                        this.employerResumeService.updateEmployerResume(
                            this.employerMapper.toEmployerResumeEntity(employerResumeDTO))));
    }
}
