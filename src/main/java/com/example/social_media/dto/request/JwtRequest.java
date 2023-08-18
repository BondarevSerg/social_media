package com.example.social_media.dto.request;

import lombok.Data;

@Data
public class JwtRequest {
    private String login;
    private String password;
}
