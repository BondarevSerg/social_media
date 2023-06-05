package com.example.social_media.mapper;

import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.request.MessageRequest;
import com.example.social_media.dto.response.InviteResponse;
import com.example.social_media.dto.response.MessageResponse;
import com.example.social_media.entity.Invite;
import com.example.social_media.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageMapper {
    MessageMapper MAPPER = Mappers.getMapper(MessageMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "message", target = "message")
    @Mapping(source = "userfrom.id", target = "userfrom")
    @Mapping(source = "userto.id", target = "userto")
    MessageResponse toDTO(Message message);

    @Mapping(source = "message", target = "message")
    @Mapping(source = "userfrom", target = "userfrom.id")
    @Mapping(source = "userto", target = "userto.id")
    Message toEntity(MessageRequest messageRequest);
}
