package com.example.social_media.service;

import com.example.social_media.dto.request.JwtRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.JwtResponse;
import com.example.social_media.exception.MyException;
import com.example.social_media.security.UserDetailsServiceImp;
import com.example.social_media.service.Imp.UserServiceImp;
import com.example.social_media.utils.JwtTokenUtils;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;



@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserDetailsServiceImp userDetailsServiceImp;
    private final UserServiceImp userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest jwtRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getLogin(), jwtRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new MyException(HttpStatus.UNAUTHORIZED.value(), "Неправильный логин или пароль"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(jwtRequest.getLogin());
        String token = jwtTokenUtils.generateToken(userDetails);


        return ResponseEntity.ok(new JwtResponse(token));
    }

    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) {

        if (userService.findByLogin(userRequest.getLogin()).isPresent()) {
            return new ResponseEntity<>(new MyException(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
       userService.saveUser(userRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
