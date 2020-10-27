package com.itrecruitmentapi.controller.job_post;

import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.service.JobPostService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/job-post")
public class JobPostController {
    private final JobPostMapper jobPostMapper;
    private final JobPostService jobPostService;

    @GetMapping("/{id}")
    public ResponseEntity<JobPostDTO> getJobPostById(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobPostMapper.toJobPostDTO(
                        this.jobPostService.getJobPostById(id)
                )
        );
    }

    @PostMapping()
    public ResponseEntity<JobPostDTO> addJobPost(@RequestBody @Validated JobPostDTO jobPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            this.jobPostMapper.toJobPostDTO(
                this.jobPostService.addJobPost(this.jobPostMapper.toJobPostEntity(jobPostDTO))
            )
        );
    }

    @PutMapping()
    public ResponseEntity<JobPostDTO> editJobPost(@RequestBody @Validated JobPostDTO jobPostDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobPostMapper.toJobPostDTO(
                        this.jobPostService.editJobPost(this.jobPostMapper.toJobPostEntity(jobPostDTO))
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteJobPost(@PathVariable("id") int id) {
        this.jobPostService.deleteJobPostById(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job post with id: " + id));
    }
}
