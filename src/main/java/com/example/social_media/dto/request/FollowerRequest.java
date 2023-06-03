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

    private Long user_id;

    private Long follower_id;
}
