package com.itrecruitmentapi.controller.job_apply;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.controller.job_apply.DTO.JobApplyDTO;
import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.controller.job_post.JobPostMapper;
import com.itrecruitmentapi.entity.CandidateResumeEntity;
import com.itrecruitmentapi.entity.JobPostEntity;
import com.itrecruitmentapi.service.JobApplyService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobApplyController {
    private final JobApplyMapper jobApplyMapper;
    private final CandidateMapper candidateMapper;
    private final JobPostMapper jobPostMapper;
    private final JobApplyService jobApplyService;

    @GetMapping("/candidate/{accountId}/job-apply")
    public ResponseEntity<List<JobPostDTO>> getAllJobApplyByAccount(@PathVariable("accountId") int accountId,
                                                                    @RequestParam("statusId") int statusId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobPostMapper.toJobPostDTOs(
                        this.jobApplyService.getAllJobPostByCandidate(accountId, statusId)
                )
        );
    }

    @GetMapping("/job-apply")
    public ResponseEntity<Boolean> checkIsApplyByCandidateAndJobPost(@RequestParam("accountId") int accountId,
                                                                    @RequestParam("jobPostId") int jobPostId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobApplyService.checkIsApplyByCandidateAndJobPost(new CandidateResumeEntity(accountId), new JobPostEntity(jobPostId))

        );
    }

    @GetMapping("/job-post/{jobPostId}/job-apply")
    public ResponseEntity<List<CandidateDTO>> getAllJobApplyByJobPost(@PathVariable("jobPostId") int jobPostId,
                                                                      @RequestParam("statusId") int statusId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.candidateMapper.toCandidateDTOs(
                        this.jobApplyService.getAllCandidateByJobPost(jobPostId, statusId)
                )
        );
    }

    @PostMapping("/job-apply")
    public ResponseEntity<ResponseMessage> addJobApply(@RequestBody JobApplyDTO jobApplyDTO) {
        this.jobApplyService.addJobApply(this.jobApplyMapper.toJobApplyEntity(jobApplyDTO));
        return ResponseEntity.ok(new ResponseMessage("you have applied"));
    }

    @PutMapping("/job-apply")
    public ResponseEntity<ResponseMessage> editJobApply(@RequestBody JobApplyDTO jobApplyDTO) {
        this.jobApplyService.editJobApply(this.jobApplyMapper.toJobApplyEntity(jobApplyDTO));
        return ResponseEntity.ok(new ResponseMessage("you have applied"));
    }

    @DeleteMapping("/job-apply/{id}")
    public ResponseEntity<ResponseMessage> deleteJobApply(@PathVariable("id") int id) {
        this.jobApplyService.deleteJobApply(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job save with id: " + id));
    }
}
