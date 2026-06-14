package com.example.placement.web;

import com.example.placement.domain.Company;
import com.example.placement.repo.CompanyRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    record CreateCompanyRequest(@NotBlank String companyName) {}

    @PostMapping("/companies")
    @ResponseStatus(HttpStatus.CREATED)
    public Company create(@Valid @RequestBody CreateCompanyRequest req) {
        return companyRepository.save(new Company(req.companyName()));
    }
}

