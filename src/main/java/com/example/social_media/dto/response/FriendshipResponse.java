package com.example.social_media.dto.response;

import lombok.Data;

@Data
public class FriendshipResponse {

    /**
     * id
     */
    private Long id;

    /**
     * id пользователя
     */
    private Long user_id;

    /**
     * id друга
     */

    private Long friend_id;

}
