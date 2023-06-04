package com.example.social_media.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * запрос подписчик
 */
@Data
@AllArgsConstructor
@Builder
public class FollowerRequest {
    /**
     * id пользователя
     */
    private Long user_id;
    /**
     * id подписчика
     */
    private Long follower_id;
}
