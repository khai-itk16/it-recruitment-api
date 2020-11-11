package com.itrecruitmentapi.controller.job_post;

import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.service.JobPostService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobPostController {
    private final JobPostMapper jobPostMapper;
    private final JobPostService jobPostService;

    @GetMapping("/job-post")
    public ResponseEntity<List<JobPostDTO>> getAllJobPostByStatus(@RequestParam(name = "statusJobPostId") int statusJobPostId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jobPostMapper.toJobPostDTOs(
                this.jobPostService.getAllJobPostByStatusJobPostId(statusJobPostId)
            )
        );
    }

    @GetMapping("/job-post/count")
    public ResponseEntity<Long> countAllJobPostsByStatus(@RequestParam("statusJobPostId") int statusJobPostId) {
        return ResponseEntity.ok(this.jobPostService.countAllJobPostsByStatus(statusJobPostId));
    }

    @GetMapping("/employer/job-post")
    public ResponseEntity<List<JobPostDTO>> getAllJobPostByEmployerAndStatus(
            @RequestParam(name = "accountId") int accountId,
            @RequestParam(name = "statusJobPostId") int statusJobPostId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jobPostMapper.toJobPostDTOs(
                this.jobPostService.getAllJobPostByEmployerIdAndStatusJobPostId(accountId, statusJobPostId)
            )
        );
    }

    @GetMapping("/job-post/{id}")
    public ResponseEntity<JobPostDTO> getJobPostById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jobPostMapper.toJobPostDTO(
                this.jobPostService.getJobPostById(id)
            )
        );
    }

    @PostMapping("/job-post")
    public ResponseEntity<JobPostDTO> addJobPost(@RequestBody @Validated JobPostDTO jobPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            this.jobPostMapper.toJobPostDTO(
                this.jobPostService.addJobPost(this.jobPostMapper.toJobPostEntity(jobPostDTO))
            )
        );
    }

    @PutMapping("/job-post")
    public ResponseEntity<JobPostDTO> editJobPost(@RequestBody @Validated JobPostDTO jobPostDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
            this.jobPostMapper.toJobPostDTO(
                this.jobPostService.editJobPost(this.jobPostMapper.toJobPostEntity(jobPostDTO))
            )
        );
    }

    @PutMapping("/job-post/{id}")
    public ResponseEntity<ResponseMessage> changeStatusJobPost(@PathVariable("id") int id,
                                                  @RequestParam("statusJobPostId") int statusJobPostId) {
        this.jobPostService.changeStatusJobPost(id, statusJobPostId);
        return ResponseEntity.ok(new ResponseMessage("change status success job post with id: " + id));
    }

    @DeleteMapping("/job-post/{id}")
    public ResponseEntity<ResponseMessage> deleteJobPost(@PathVariable("id") int id) {
        this.jobPostService.deleteJobPostById(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job post with id: " + id));
    }
}
