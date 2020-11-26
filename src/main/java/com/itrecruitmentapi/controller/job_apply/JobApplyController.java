package com.itrecruitmentapi.controller.job_apply;

import com.itrecruitmentapi.controller.account.CandidateMapper;
import com.itrecruitmentapi.controller.account.DTO.CandidateDTO;
import com.itrecruitmentapi.controller.job_apply.DTO.JobApplyDTO;
import com.itrecruitmentapi.controller.job_post.DTO.JobPostDTO;
import com.itrecruitmentapi.controller.job_post.JobPostMapper;
import com.itrecruitmentapi.entity.*;
import com.itrecruitmentapi.service.JobApplyService;
import com.itrecruitmentapi.shared.ResponseMessage;
import com.itrecruitmentapi.shared.model.ApplyFilter;
import com.itrecruitmentapi.shared.model.CandidateFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class JobApplyController {
    private final JobApplyMapper jobApplyMapper;
    private final CandidateMapper candidateMapper;
    private final JobPostMapper jobPostMapper;
    private final JobApplyService jobApplyService;
    private final RestTemplate restTemplate;

    @GetMapping("/candidate/{accountId}/job-apply")
    public ResponseEntity<List<JobPostDTO>> getAllJobApplyByAccountAndStatus(@PathVariable("accountId") int accountId,
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
    public ResponseEntity<List<JobApplyDTO>> getAllJobApplyByJobPostAndStatus(@PathVariable("jobPostId") int jobPostId,
                                                                      @RequestParam("statusId") int statusId) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobApplyMapper.toJobApplyDTOs(
                        this.jobApplyService.getAllCandidateByJobPost(jobPostId, statusId)
                )
        );
    }

    @GetMapping("/job-post/{jobPostId}/job-apply/filter")
    public ResponseEntity<ResponseMessage> filterAllJobApply(@PathVariable("jobPostId") int jobPostId) {
        String URL_FILTER_CV = "http://localhost:5000/data";
        List<JobApplyEntity> jobApplyEntities = this.jobApplyService.filterJobApplyCandidateStep1(jobPostId);
        ApplyFilter applyFilter = new ApplyFilter();
        String jobRequire = jobApplyEntities.get(0).getJobPostEntity().getJobRequire() + jobApplyEntities.get(0).getJobPostEntity().getJobDescription();
        applyFilter.setJobPostId(jobPostId);
        applyFilter.setJobRequire(jobRequire);
        for (JobApplyEntity jobApplyEntity : jobApplyEntities) {
            String skillAndExperience = "";
            List<SkillEntity> skillEntities = (List<SkillEntity>) jobApplyEntity.getCandidateResumeEntity().getSkillEntities();
            List<ExperienceEntity> experienceEntities = (List<ExperienceEntity>) jobApplyEntity.getCandidateResumeEntity().getExperienceEntities();
            for (SkillEntity skillEntity : skillEntities) {
                skillAndExperience += (skillEntity.getSkillName() + " " + skillEntity.getDescription()) + " ";
            }

            for (ExperienceEntity experienceEntity : experienceEntities) {
                skillAndExperience += (experienceEntity.getExperienceName() + " " + experienceEntity.getDescription()) + " ";
            }
            applyFilter.getCandidateFilters().add(new CandidateFilter(jobApplyEntity.getCandidateResumeEntity().getAccountId(), skillAndExperience, 0.0));
        }
        HttpEntity<ApplyFilter> requestBody = new HttpEntity<>(applyFilter);

        ApplyFilter applyAfterFilter = this.restTemplate.postForObject(URL_FILTER_CV, requestBody, ApplyFilter.class);
        int lengthCandidates = applyAfterFilter.getCandidateFilters().size();
        for (JobApplyEntity jobApplyEntity : jobApplyEntities) {
            for(int i = 0; i < lengthCandidates; i++) {
                if(jobApplyEntity.getCandidateResumeEntity().getAccountId()
                        == applyAfterFilter.getCandidateFilters().get(i).getAccountId()) {

                    jobApplyEntity.setMatchPercent(applyAfterFilter.getCandidateFilters().get(i).getMatchPercent());
                    if(applyAfterFilter.getCandidateFilters().get(i).getMatchPercent() < 20) {
                        jobApplyEntity.setStatusEntity(new StatusEntity(7)); // 7 is status not match with job
                    } else {
                        jobApplyEntity.setStatusEntity(new StatusEntity(6)); // 6 is status match with job
                    }
                }
            }
        }
        this.jobApplyService.updateAllJobAppliesAfterFilter(jobApplyEntities);
        return ResponseEntity.ok(new ResponseMessage("The CVs have been classified"));
    }

    @GetMapping("/job-post/{jobPostId}/job-apply/filter-step-1")
    public ResponseEntity<List<JobApplyDTO>> filterJobApplyCandidateStep1(@PathVariable("jobPostId") int jobPostId) {
        return ResponseEntity.status(HttpStatus.OK).body(
             this.jobApplyMapper.toJobApplyDTOs(
                     this.jobApplyService.filterJobApplyCandidateStep1(jobPostId)
             )
        );
    }

    @PostMapping("/job-apply")
    public ResponseEntity<ResponseMessage> addJobApply(@RequestBody JobApplyDTO jobApplyDTO) {
        this.jobApplyService.addJobApply(this.jobApplyMapper.toJobApplyEntity(jobApplyDTO));
        return ResponseEntity.ok(new ResponseMessage("you have applied"));
    }

    @PutMapping("/job-apply/{id}/change-status")
    public ResponseEntity<ResponseMessage> changeStatusJobApply(@PathVariable("id") int jobApplyId, @RequestParam("statusId") int statusId) {
        this.jobApplyService.changeStatusJobApply(jobApplyId, statusId);
        return ResponseEntity.ok(new ResponseMessage("you have change status"));
    }

    @DeleteMapping("/job-apply/{id}")
    public ResponseEntity<ResponseMessage> deleteJobApply(@PathVariable("id") int id) {
        this.jobApplyService.deleteJobApply(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job apply with id: " + id));
    }
}
