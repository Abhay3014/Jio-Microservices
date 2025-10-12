package com.jio.user_service.service;



import com.jio.user_service.dto.LoginRequest;
import com.jio.user_service.dto.UserDto;
import com.jio.user_service.model.User;
import com.jio.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto register(User user) {
        User saved = userRepository.save(user);
        return new UserDto(saved.getId(), saved.getUsername(), saved.getEmail());
    }

    public UserDto login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(request.getPassword())) {
            User user = userOpt.get();
            return new UserDto(user.getId(), user.getUsername(), user.getEmail());
        }
        throw new RuntimeException("Invalid credentials");
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserDto(user.getId(), user.getUsername(), user.getEmail());
    }
}
