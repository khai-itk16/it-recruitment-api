package com.itrecruitmentapi.controller.job_type;

import com.itrecruitmentapi.controller.job_type.DTO.JobTypeDTO;
import com.itrecruitmentapi.service.JobTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/job-type")
public class JobTypeController {
    public final JobTypeService jobTypeService;
    public final JobTypeMapper jobTypeMapper;

    @GetMapping()
    public ResponseEntity<List<JobTypeDTO>> getAllJobPositions() {
        return ResponseEntity.ok(this.jobTypeMapper.toJobTypeDTOs(
                this.jobTypeService.getAllJobTypes()));
    }
}
