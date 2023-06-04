package com.example.social_media.dto.response;


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
     * содержимое поста(например текст)
     */

    private String postMessage;

    /**
     * id автора поста
     */

    private Long user_id;
}
