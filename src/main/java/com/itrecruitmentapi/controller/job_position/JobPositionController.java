package com.itrecruitmentapi.controller.job_position;

import com.itrecruitmentapi.controller.job_position.DTO.JobPositionDTO;
import com.itrecruitmentapi.service.JobPositionService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/count")
    public ResponseEntity<Long> countAllJobPositions() {
        return ResponseEntity.ok(this.jobPositionService.countAllJobPositions());
    }

    @PostMapping()
    public ResponseEntity<JobPositionDTO> addJobPosition(@RequestBody @Validated JobPositionDTO jobPositionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                this.jobPositionMapper.toJobPositionDTO(
                        this.jobPositionService.addJobPosition(this.jobPositionMapper.toJobPositionEntity(jobPositionDTO))
                )
        );
    }

    @PutMapping()
    public ResponseEntity<JobPositionDTO> editJobPosition(@RequestBody @Validated JobPositionDTO jobPositionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.jobPositionMapper.toJobPositionDTO(
                        this.jobPositionService.editJobPosition(this.jobPositionMapper.toJobPositionEntity(jobPositionDTO))
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteJobPosition(@PathVariable("id") int id) {
        this.jobPositionService.deleteJobPositionById(id);
        return ResponseEntity.ok(new ResponseMessage("delete success job position with id: " + id));
    }

}
