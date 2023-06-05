package com.example.social_media.mapper;

import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.response.InviteResponse;
import com.example.social_media.entity.Invite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InviteMapper {

    InviteMapper MAPPER = Mappers.getMapper(InviteMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userfrom.id", target = "userfrom")
    @Mapping(source = "userto.id", target = "userto")
    InviteResponse toDTO(Invite invite);


    @Mapping(source = "userfrom", target = "userfrom.id")
    @Mapping(source = "userto", target = "userto.id")
    Invite toEntity(InviteRequest inviteRequest);
}
