package com.example.social_media.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendshipRequest {

    private Long user_id;

    private Long friend_id;
}
