package com.example.social_media.controller;

import com.example.social_media.dto.request.JwtRequest;
import com.example.social_media.dto.request.UserRegistrationRequest;
import com.example.social_media.service.AuthService;
import com.example.social_media.service.Imp.UserServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер регистрации пользователя
 */
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest jwtRequest) {
        return authService.createAuthToken(jwtRequest);
    }

    /**
     * регистрация нового пользователя
     * @param userRegistrationRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "регистрация нового пользователя")
    public ResponseEntity<HttpStatus> create(@RequestBody UserRegistrationRequest userRegistrationRequest) {

        authService.saveUser(userRegistrationRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
