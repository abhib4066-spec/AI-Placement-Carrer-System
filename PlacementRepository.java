package com.example.placement.repo;

import com.example.placement.domain.Placement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacementRepository extends JpaRepository<Placement, Long> {}

