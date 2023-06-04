package com.example.social_media.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    private  LocalDateTime date ;
}
