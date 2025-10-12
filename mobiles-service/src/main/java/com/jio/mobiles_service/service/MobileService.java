package com.jio.mobiles_service.service;

import com.jio.mobiles_service.model.Mobile;
import com.jio.mobiles_service.repository.MobileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {

    private final MobileRepository mobileRepository;

    public MobileService(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public Mobile addMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    public List<Mobile> getAllMobiles() {
        return mobileRepository.findAll();
    }

    public Mobile getMobileById(Long id) {
        return mobileRepository.findById(id).orElse(null);
    }

    public List<Mobile> getMobilesByUserId(Long userId) {
        return mobileRepository.findByUserId(userId);
    }
}

