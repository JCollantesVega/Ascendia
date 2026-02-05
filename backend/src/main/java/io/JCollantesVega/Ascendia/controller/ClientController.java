package io.JCollantesVega.Ascendia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.JCollantesVega.Ascendia.dto.user.UserResponse;
import io.JCollantesVega.Ascendia.mapper.UserMapper;
import io.JCollantesVega.Ascendia.model.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {
    private final UserMapper userMapper;
    
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getMyProfile(@AuthenticationPrincipal User user){
        return ResponseEntity.ok(userMapper.toUserResponse(user));
    }
}
