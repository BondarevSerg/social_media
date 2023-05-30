package com.example.social_media.dto.response;


import lombok.Data;

import java.util.List;

@Data

public class UserResponse {

    /**
     * id
     */
    private Long id;

    /**
     * логин
     */
    private String login;

    /**
     * роль
     */
    private String role;

    /**
     * почта
     */

    private String email;

    /**
     * Список постов
     */

    private List<PostResponse> posts;
}
