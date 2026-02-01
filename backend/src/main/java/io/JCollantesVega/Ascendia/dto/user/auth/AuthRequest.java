package io.JCollantesVega.Ascendia.dto.user.auth;

public record AuthRequest(
    String email,
    String password
){
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
