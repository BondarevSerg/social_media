package com.example.social_media.dto.request;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String login;
    private String password;
    private String confirmPassword;
    private String email;
}
