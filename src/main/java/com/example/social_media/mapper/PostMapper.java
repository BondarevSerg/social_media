package com.example.social_media.mapper;

import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.Post;
import com.example.social_media.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "user_id")
    @Mapping(source = "postMessage", target = "postMessage")
    @Mapping(source = "date", target = "date")
    PostResponse toDto(Post post);

}
