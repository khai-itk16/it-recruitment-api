package com.itrecruitmentapi.controller.job_save;

import com.itrecruitmentapi.controller.job_save.DTO.JobSaveDTO;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
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

    @GetMapping("/job-save/check")
    public ResponseEntity<Boolean> checkJobSaveExist(@RequestParam(name = "accountId") int accountId,
                                                         @RequestParam(name = "jobPostId") int jobPostId) {
        CandidateResumeEntity candidateResumeEntity = new CandidateResumeEntity(accountId);
        JobPostEntity jobPostEntity = new JobPostEntity(jobPostId);
        return ResponseEntity.status(HttpStatus.OK).body(
               this.jobSaveService.checkJobSaveExist(candidateResumeEntity, jobPostEntity)
        );
    }

    @PostMapping("/job-save")
    public ResponseEntity<ResponseMessage> addJobSave(@RequestBody JobSaveDTO jobSaveDTO) {
        this.jobSaveService.addJobSave(this.jobSaveMapper.toJobSaveEntity(jobSaveDTO));
        return ResponseEntity.ok(new ResponseMessage("job has saved"));
    }

    @DeleteMapping("/job-save/{id}")
    public ResponseEntity<ResponseMessage> deleteJobSaveById(@PathVariable int id) {
        this.jobSaveService.deleteJobSaveById(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job save with id: " + id));
    }

    @DeleteMapping("/job-save")
    public ResponseEntity<ResponseMessage> deleteJobSave(@RequestParam(name = "accountId") int accountId,
                                                         @RequestParam(name = "jobPostId") int jobPostId) {
        CandidateResumeEntity candidateResumeEntity = new CandidateResumeEntity(accountId);
        JobPostEntity jobPostEntity = new JobPostEntity(jobPostId);
        this.jobSaveService.deleteJobSave(candidateResumeEntity, jobPostEntity);
        return ResponseEntity.ok(new ResponseMessage("delete success job save"));
    }
}
