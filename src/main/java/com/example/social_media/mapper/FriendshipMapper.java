package com.example.social_media.mapper;


import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.response.FriendshipResponse;

import com.example.social_media.entity.Friendship;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FriendshipMapper {

    FriendshipMapper MAPPER = Mappers.getMapper(FriendshipMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "friend.id", target = "friend_id")
    FriendshipResponse toDto(Friendship friendship);


}
