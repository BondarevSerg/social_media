package com.example.social_media.dto.response;

import lombok.Data;

@Data
public class FriendshipResponse {

    /**
     * id пользователя
     */
    private Long id;

    /**
     * id друга
     */

    private Long friend_id;

}
