package com.example.social_media.dto.response;

import lombok.Data;

@Data
public class InviteResponse {
    /**
     * id
     */
    private Long id;

    /**
     * id пользователя от кого заявка
     */
    private Long userfrom;

    /**
     * id пользователя кому заявка
     */

    private Long userto;
}
