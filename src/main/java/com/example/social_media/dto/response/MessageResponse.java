package com.example.social_media.dto.response;

import lombok.Data;

@Data
public class MessageResponse {

    /**
     * id сообщения
     */
    private Long id;
    /**
     *  сообщение
     */
    private String message;
    /**
     * id пользователя от кого сообщение
     */
    private Long userfrom;

    /**
     * id пользователя кому сообщение
     */

    private Long userto;
}
