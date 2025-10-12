package com.jio.devices_service.repository;

import com.jio.devices_service.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
