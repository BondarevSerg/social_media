package com.example.social_media.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequest {
    /**
     * Сообщение(содержимое поста)
     */

    private String message;

    /**
     * id автор поста
     */

    private Long UserId;
}
