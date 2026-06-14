package com.example.placement.repo;

import com.example.placement.domain.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findAllByStudent_Id(Long studentId);
}

