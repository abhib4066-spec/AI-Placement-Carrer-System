package com.example.placement.web;

import com.example.placement.domain.Skill;
import com.example.placement.domain.Student;
import com.example.placement.repo.SkillRepository;
import com.example.placement.repo.StudentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillRepository skillRepository;
    private final StudentRepository studentRepository;

    public SkillController(SkillRepository skillRepository, StudentRepository studentRepository) {
        this.skillRepository = skillRepository;
        this.studentRepository = studentRepository;
    }

    record AddSkillRequest(
            @NotBlank String name,
            String level
    ) {}

    @PostMapping("/students/{studentId}/skills")
    @ResponseStatus(HttpStatus.CREATED)
    public Skill addSkill(
            @PathVariable Long studentId,
            @Valid @RequestBody AddSkillRequest req
    ) {
        Student s = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));

        return skillRepository.save(new Skill(s, req.name(), req.level()));
    }

    @GetMapping("/students/{studentId}/skills")
    public List<Skill> listSkills(@PathVariable @NotNull Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found: " + studentId);
        }
        return skillRepository.findAllByStudent_Id(studentId);
    }
}

