package com.example.social_media.dto.request;

import lombok.Data;

@Data
public class InviteRequest {

    /**
     * id пользователя от кого заявка
     */
    private Long userfrom;

    /**
     * id пользователя кому заявка
     */

    private Long userto;
}
