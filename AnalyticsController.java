package com.example.placement.web;

import com.example.placement.repo.CompanyRepository;
import com.example.placement.repo.PlacementRepository;
import com.example.placement.repo.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "*")
public class AnalyticsController {

    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final PlacementRepository placementRepository;

    public AnalyticsController(StudentRepository studentRepository,
                                CompanyRepository companyRepository,
                                PlacementRepository placementRepository) {
        this.studentRepository = studentRepository;
        this.companyRepository = companyRepository;
        this.placementRepository = placementRepository;
    }

    @GetMapping("/stats")
    public Map<String, Object> stats() {
        return Map.of(
                "students", studentRepository.count(),
                "companies", companyRepository.count(),
                "placements", placementRepository.count()
        );
    }
}

