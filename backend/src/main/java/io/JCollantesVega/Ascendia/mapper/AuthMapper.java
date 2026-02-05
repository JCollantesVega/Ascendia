package io.JCollantesVega.Ascendia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import io.JCollantesVega.Ascendia.dto.user.auth.AuthResponse;
import io.JCollantesVega.Ascendia.dto.user.register.RegisterResponse;
import io.JCollantesVega.Ascendia.model.User;

@Mapper(componentModel = "spring")
public interface AuthMapper {
    
    AuthMapper INSTANCE = Mappers.getMapper(AuthMapper.class);
    
    @Mapping(target = "username", source = "user.username")
    AuthResponse toAuthResponse(User user, String token);
    
    @Mapping(target = "username", source = "user.username")
    RegisterResponse toRegisterResponse(User user, String token);
}