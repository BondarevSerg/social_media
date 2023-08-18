package com.example.social_media.controller;

import com.example.social_media.dto.request.JwtRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер регистрации пользователя и получение токена
 */
@RestController
@RequiredArgsConstructor
@Tag(
        name = "Регистрация",
        description = "контроллер регистрации пользователя"
)
public class AuthController {

    private final AuthService authService;

    /**
     * получение токена
     * @param jwtRequest
     * @return
     */
    @PostMapping("/auth")
    @Operation(summary = "получение токена")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest jwtRequest) {
        return authService.createAuthToken(jwtRequest);
    }

    /**
     * регистрация нового пользователя
     * @param userRequest
     * @return
     */
    @PostMapping("/registration")
    @Operation(summary = "регистрация нового пользователя")
    public ResponseEntity<HttpStatus> create(@RequestBody UserRequest userRequest) {

        authService.saveUser(userRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
