package com.itrecruitmentapi.controller.skill;

import com.itrecruitmentapi.controller.skill.DTO.SkillDTO;
import com.itrecruitmentapi.service.SkillService;
import com.itrecruitmentapi.shared.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/skill")
public class SkillController {
    public final SkillMapper skillMapper;
    public final SkillService skillService;

    @GetMapping()
    public ResponseEntity<List<SkillDTO>> getSkillByAccountId(
            @RequestParam(name = "accountId", required = false) int accountId) {
        return ResponseEntity.ok(this.skillMapper.toSkillDTOs(
                this.skillService.getSkillByAccountId(accountId)));
    }

    @PostMapping()
    public ResponseEntity<SkillDTO> addSkill(@RequestBody @Validated SkillDTO skillDTO) {
        return ResponseEntity.ok(this.skillMapper.toSkillDTO(this.skillService
                .editSkill(this.skillMapper.toSkillEntity(skillDTO))));
    }

    @PutMapping()
    public ResponseEntity<SkillDTO> editSkill(@RequestBody @Validated SkillDTO skillDTO) {
        return ResponseEntity.ok(this.skillMapper.toSkillDTO(this.skillService
                .editSkill(this.skillMapper.toSkillEntity(skillDTO))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage>  deleteSkill(@PathVariable("id") int id) {
        this.skillService.deleteSkillById(id);
        return  ResponseEntity.ok(new ResponseMessage("delete success skill with id: " + id));
    }
}
