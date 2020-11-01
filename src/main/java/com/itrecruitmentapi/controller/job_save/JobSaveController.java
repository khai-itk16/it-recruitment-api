package com.itrecruitmentapi.controller.job_save;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.controller.job_post.JobPostMapper;
import com.itrecruitmentapi.controller.job_save.DTO.JobSaveDTO;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.service.JobSaveService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobSaveController {

    private final JobSaveMapper jobSaveMapper;
    private final JobSaveService jobSaveService;

    @GetMapping("/job-save")
    public ResponseEntity<List<JobSaveDTO>> getAllJobSaveByAccount(@RequestParam(name = "accountId") int accountId) {
        CandidateResumeEntity candidateResumeEntity = new CandidateResumeEntity(accountId);
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobSaveMapper.toJobSaveDTOs(
                        this.jobSaveService.getAllJobSavesByCandidate(candidateResumeEntity)
                )
        );
    }

    @PostMapping("/job-save")
    public ResponseEntity<ResponseMessage> addJobSave(@RequestBody JobSaveDTO jobSaveDTO) {
        this.jobSaveService.addJobSave(this.jobSaveMapper.toJobSaveEntity(jobSaveDTO));
        return ResponseEntity.ok(new ResponseMessage("job has saved"));
    }

    @DeleteMapping("/job-save")
    public ResponseEntity<ResponseMessage> deleteJobSave(@RequestParam(name = "jobSaveId") int jobSaveId) {
        this.jobSaveService.deleteJobSave(jobSaveId);
        return ResponseEntity.ok(new ResponseMessage("delete success job save with id: " + jobSaveId));
    }
}
