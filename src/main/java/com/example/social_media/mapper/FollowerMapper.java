package com.example.social_media.mapper;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;
import com.example.social_media.entity.Follower;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FollowerMapper {
    FollowerMapper MAPPER = Mappers.getMapper(FollowerMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "follower.id", target = "follower_id")
    FollowerResponse toDto(Follower follower);


    @Mapping(source = "user_id", target = "user.id")
    @Mapping(source = "follower_id", target = "follower.id")
    Follower toEntity(FollowerRequest followerRequest);

}
