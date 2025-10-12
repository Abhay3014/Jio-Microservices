package com.jio.user_service.controller;

import com.jio.user_service.dto.LoginRequest;
import com.jio.user_service.dto.UserDto;
import com.jio.user_service.model.User;
import com.jio.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
