package com.example.social_media.dto.request;


import lombok.Data;

@Data
public class FriendshipRequest {

    private Long user_id;

    private Long friend_id;
}
