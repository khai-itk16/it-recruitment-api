package com.itrecruitmentapi.controller.experience;

import com.itrecruitmentapi.controller.experience.DTO.ExperienceDTO;
import com.itrecruitmentapi.service.ExperienceService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
    public final ExperienceMapper experienceMapper;
    public final ExperienceService experienceService;

    @GetMapping()
    public ResponseEntity<List<ExperienceDTO>> getExperiencesByAccountId(
            @RequestParam(name = "accountId", required = false) int accountId) {
        return ResponseEntity.ok(this.experienceMapper.toExperienceDTOs(
                this.experienceService.getExperiencesByAccountId(accountId)));
    }

    @PostMapping()
    public ResponseEntity<ExperienceDTO> addExperience(@RequestBody @Validated ExperienceDTO experienceDTO) {
        return ResponseEntity.ok(this.experienceMapper.toExperienceDTO(this.experienceService
                .addExperience(this.experienceMapper.toExperienceEntity(experienceDTO))));
    }

    @PutMapping()
    public ResponseEntity<ExperienceDTO> editExperience(@RequestBody @Validated ExperienceDTO experienceDTO) {
        return ResponseEntity.ok(this.experienceMapper.toExperienceDTO(this.experienceService
                .editExperience(this.experienceMapper.toExperienceEntity(experienceDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage>  deleteExperience(@PathVariable("id") int id) {
        this.experienceService.deleteExperienceById(id);
        return  ResponseEntity.ok(new ResponseMessage("delete success experience with id: " + id));
    }
}
