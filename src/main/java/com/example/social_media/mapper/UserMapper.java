package com.example.social_media.mapper;

import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(uses = { PostMapper.class })

public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
//    @Mapping(source = "posts", target = "posts")
    UserResponse toDto(User user);
}