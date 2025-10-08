package com.jio.mobiles_service.controller;

import com.jio.mobiles_service.model.Mobile;
import com.jio.mobiles_service.service.MobileService;
import com.jio.mobiles_service.feign.UserClient;
import com.jio.mobiles_service.feign.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mobiles")
public class MobileController {

    @Autowired
    private final MobileService mobileService;
    private final UserClient userClient;

    public MobileController(MobileService mobileService, UserClient userClient) {
        this.mobileService = mobileService;
        this.userClient = userClient;
    }

    @PostMapping
    public ResponseEntity<Mobile> addMobile(@RequestBody Mobile mobile) {
        Mobile saved = mobileService.addMobile(mobile);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Mobile>> getAll() {
        return ResponseEntity.ok(mobileService.getAllMobiles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mobile> getById(@PathVariable Long id) {
        Mobile m = mobileService.getMobileById(id);
        if (m == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(m);
    }

    @GetMapping("/for-user/{userId}")
    public ResponseEntity<Object> getMobilesForUser(@PathVariable Long userId) {
        try {
            UserDto user = userClient.getUserById(userId);
            return ResponseEntity.ok(mobileService.getAllMobiles());
        } catch (Exception e) {
            return ResponseEntity.status(502).body("Unable to fetch user from user-service");
        }
    }
}
