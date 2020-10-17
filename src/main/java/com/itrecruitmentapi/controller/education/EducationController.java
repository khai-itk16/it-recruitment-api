package com.itrecruitmentapi.controller.education;

import com.itrecruitmentapi.controller.education.DTO.EducationDTO;
import com.itrecruitmentapi.service.EducationService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/education")
public class EducationController {

    public final EducationMapper educationMapper;
    public final EducationService educationService;

    @GetMapping()
    public ResponseEntity<List<EducationDTO>> getEducationsByAccountId(
            @RequestParam(name = "accountId", required = false) int accountId) {
        return ResponseEntity.ok(this.educationMapper.toEducationDTOs(
                this.educationService.getEducationsByAccountId(accountId)));
    }

    @PostMapping()
    public ResponseEntity<EducationDTO>addEducation(@RequestBody @Validated EducationDTO educationDTO) {
        System.out.println("educationDTO: " +educationDTO);
        System.out.println("======");
        System.out.println("education entity: " + this.educationMapper.toEducationEntity(educationDTO));
        System.out.println("======");
        return ResponseEntity.ok(this.educationMapper.toEducationDTO(this.educationService
                .addEducation(this.educationMapper.toEducationEntity(educationDTO))));
    }

    @PutMapping()
    public ResponseEntity<EducationDTO> editEducation(@RequestBody @Validated EducationDTO educationDTO) {
        System.out.println("educationDTO: " +educationDTO);
        System.out.println("======");
        System.out.println("education entity: " + this.educationMapper.toEducationEntity(educationDTO));
        System.out.println("======");
        return ResponseEntity.ok(this.educationMapper.toEducationDTO(this.educationService
                .editEducation(this.educationMapper.toEducationEntity(educationDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage>  deleteEducation(@PathVariable("id") int id) {
        this.educationService.deleteEducationById(id);
        return  ResponseEntity.ok(new ResponseMessage("delete success education with id: " + id));
    }
}
