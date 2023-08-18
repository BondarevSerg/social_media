package com.example.social_media.dto.request;

//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Необходимо указать логин")
    private String login;

    @NotBlank(message = "Необходимо указать пароль")
    private String password;

    @Email(message = "Email должен быть корректным")
    private String email;

}
