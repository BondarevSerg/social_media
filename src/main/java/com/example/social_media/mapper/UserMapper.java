package com.example.social_media.mapper;

import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = { PostMapper.class, FriendshipMapper.class,
        FollowerMapper.class, InviteMapper.class, MessageMapper.class })

public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
     @Mapping(source = "myInvitesIn", target = "myInvitesIn")
    @Mapping(source = "myInvitesOut", target = "myInvitesOut")
    @Mapping(source = "myMessageIn", target = "myMessageIn")
    @Mapping(source = "myMessageOut", target = "myMessageOut")
    UserResponse toDto(User user);
}
