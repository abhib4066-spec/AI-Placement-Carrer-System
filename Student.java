package com.example.placement.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "cgpa", nullable = false, precision = 3, scale = 2)
    private BigDecimal cgpa;

    @Column(nullable = false)
    private String email;

    public Student() {}

    public Student(String fullName, BigDecimal cgpa, String email) {
        this.fullName = fullName;
        this.cgpa = cgpa;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public BigDecimal getCgpa() { return cgpa; }
    public void setCgpa(BigDecimal cgpa) { this.cgpa = cgpa; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

