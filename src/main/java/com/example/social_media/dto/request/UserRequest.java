package com.example.social_media.dto.request;


import lombok.Data;



@Data
public class UserRequest {

    private String login;

    private String password;

    private String email;

}
