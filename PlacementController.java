package com.example.placement.web;

import com.example.placement.domain.Company;
import com.example.placement.domain.Placement;
import com.example.placement.domain.Student;
import com.example.placement.repo.CompanyRepository;
import com.example.placement.repo.PlacementRepository;
import com.example.placement.repo.StudentRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PlacementController {

    private final PlacementRepository placementRepository;
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;

    public PlacementController(PlacementRepository placementRepository,
                                StudentRepository studentRepository,
                                CompanyRepository companyRepository) {
        this.placementRepository = placementRepository;
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
    }

    record CreatePlacementRequest(
            @NotNull Long studentId,
            @NotNull Long companyId,
            @NotBlank String status,
            String notes
    ) {}

    @PostMapping("/placements")
    @ResponseStatus(HttpStatus.CREATED)
    public Placement create(@Valid @RequestBody CreatePlacementRequest req) {
        Student s = studentRepository.findById(req.studentId())
                .orElseThrow(() -> new RuntimeException("Student not found: " + req.studentId()));
        Company c = companyRepository.findById(req.companyId())
                .orElseThrow(() -> new RuntimeException("Company not found: " + req.companyId()));

        return placementRepository.save(new Placement(s, c, req.status(), req.notes()));
    }
}

