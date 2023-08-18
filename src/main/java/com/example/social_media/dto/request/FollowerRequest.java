package com.example.social_media.dto.request;


import lombok.Builder;
import lombok.Data;

/**
 * запрос подписчик
 */
@Data
@Builder
public class FollowerRequest {
    /**
     * id пользователя
     */
    private Long user_id;
    /**
     * id его подписчика
     */
    private Long follower_id;
}
