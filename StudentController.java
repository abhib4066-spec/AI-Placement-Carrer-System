package com.example.placement.web;

import com.example.placement.domain.Student;
import com.example.placement.repo.StudentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    record CreateStudentRequest(
            @NotBlank String fullName,
            @NotNull BigDecimal cgpa,
            @NotBlank @Email String email
    ) {}

    record EligibilityRequest(@NotNull BigDecimal minCgpa) {}

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody CreateStudentRequest req) {
        return studentRepository.save(new Student(req.fullName(), req.cgpa(), req.email()));
    }

    @PostMapping("/students/{studentId}/eligibility")
    public Map<String, Object> checkEligibility(
            @PathVariable Long studentId,
            @Valid @RequestBody EligibilityRequest req
    ) {
        Student s = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found: " + studentId));

        boolean eligible = s.getCgpa().compareTo(req.minCgpa()) >= 0;
        return Map.of(
                "studentId", s.getId(),
                "cgpa", s.getCgpa(),
                "minCgpa", req.minCgpa(),
                "eligible", eligible
        );
    }
}

