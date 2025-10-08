package com.jio.mobiles_service.repository;

import com.jio.mobiles_service.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Long> {
}
