package miu.edu.postapp.controller;
import miu.edu.postapp.entity.dto.request.LoginRequest;
import miu.edu.postapp.entity.dto.response.LoginResponse;
import miu.edu.postapp.entity.dto.request.RefreshTokenRequest;
import miu.edu.postapp.service.AuthService;
import lombok.extern.java.Log;
import miu.edu.postapp.service.LoggerService;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    private final AuthService authService;
    private final LoggerService loggerService;
    public AuthController(AuthService authService, LoggerService loggerService) {
        this.authService = authService;
        this.loggerService = loggerService;
    }


    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        loggerService.logOperation("Login request  " + loginRequest.getUsername());
        var loginResponse = authService.login(loginRequest);
        return new ResponseEntity<LoginResponse>(
                loginResponse, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authService.refreshToken(refreshTokenRequest);
    }
}