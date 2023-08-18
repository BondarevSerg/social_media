package com.example.social_media.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PostRequest {
    /**
     * содержимое поста
     */

    private String postMessage;

    /**
     * id автор поста
     */

    private Long user_id;
}
