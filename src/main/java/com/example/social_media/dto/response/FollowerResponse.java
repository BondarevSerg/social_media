package com.example.social_media.dto.response;

import lombok.Data;

@Data
public class FollowerResponse {

    /**
     * id
     */
    private Long id;

    /**
     * id пользователя
     */
    private Long user_id;

    /**
     * id подписчика
     */

    private Long follower_id;
}
