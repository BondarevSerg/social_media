package com.example.social_media.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FriendshipRequest {

    private Long user_id;

    private Long friend_id;
}
