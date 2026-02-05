package io.JCollantesVega.Ascendia.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.JCollantesVega.Ascendia.Repository.UserRepository;
import io.JCollantesVega.Ascendia.dto.user.auth.AuthRequest;
import io.JCollantesVega.Ascendia.dto.user.auth.AuthResponse;
import io.JCollantesVega.Ascendia.dto.user.register.RegisterRequest;
import io.JCollantesVega.Ascendia.mapper.AuthMapper;
import io.JCollantesVega.Ascendia.model.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthMapper authMapper;

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

    public AuthResponse login(AuthRequest request) {
        // Autenticar al usuario
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        // Obtener el usuario
        User user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        // Generar el token
        String token = jwtService.generateToken(user);

        // Devolver el token
        return authMapper.toAuthResponse(user, token);
    }
}
