package com.example.social_media.dto.response;

import com.example.social_media.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResponse {

    /**
     * id
     */

    private Long id;

    /**
     * Сообщение(содержимое поста)
     */

    private String message;

    /**
     * id автора поста
     */

    private Long user_id;
}
