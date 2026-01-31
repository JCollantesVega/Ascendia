package io.JCollantesVega.Ascendia.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.JCollantesVega.Ascendia.Repository.UserRepository;
import io.JCollantesVega.Ascendia.dto.user.RegisterRequest;
import io.JCollantesVega.Ascendia.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    //private final JwtService jwtService;

    public void register(RegisterRequest request) {
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("User with email " + request.getEmail() + " already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setAvatarUrl(request.getAvatarUrl());
        
        userRepository.save(user);
    }
}
