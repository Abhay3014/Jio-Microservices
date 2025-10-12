package com.jio.mobiles_service.repository;

import com.jio.mobiles_service.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
