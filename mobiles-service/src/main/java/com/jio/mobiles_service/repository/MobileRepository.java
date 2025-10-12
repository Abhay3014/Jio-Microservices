package com.jio.mobiles_service.repository;


import com.jio.mobiles_service.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
    List<Mobile> findByUserId(Long userId);
}
