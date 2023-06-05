package com.example.social_media.dto.request;

import lombok.Data;

@Data
public class MessageRequest {

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
