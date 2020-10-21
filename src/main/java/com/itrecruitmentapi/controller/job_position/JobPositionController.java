package com.itrecruitmentapi.controller.job_position;

import com.itrecruitmentapi.controller.job_position.DTO.JobPositionDTO;
import com.itrecruitmentapi.service.JobPositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/job-position")
public class JobPositionController {
    public final JobPositionService jobPositionService;
    public final JobPositionMapper jobPositionMapper;

    @GetMapping()
    public ResponseEntity<List<JobPositionDTO>> getAllJobPositions() {
        return ResponseEntity.ok(this.jobPositionMapper.toJobPositionDTOs(
                this.jobPositionService.getAllJobPositions()));
    }
}
