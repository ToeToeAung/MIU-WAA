package miu.edu.postapp.service;

import miu.edu.postapp.entity.dto.request.LoginRequest;
import miu.edu.postapp.entity.dto.response.LoginResponse;
import miu.edu.postapp.entity.dto.request.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}