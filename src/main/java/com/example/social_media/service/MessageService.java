package com.example.social_media.service;

import com.example.social_media.dto.request.MessageRequest;
import com.example.social_media.dto.response.MessageResponse;


import java.util.List;

public interface MessageService {
    /**
     * Получение сообщения по id
     *
     * @return
     */
    MessageResponse getMessageById(Long id);

    /**
     * Получение списка входящих сообщений по id пользователя
     *
     * @return
     */
    List<MessageResponse> getAllMessageIn(Long id);

    /**
     * Получение списка исходящих сообщений по id пользователя
     *
     * @return
     */
    List<MessageResponse> getAllMessageOut(Long id);

    /**
     * сохранение нового сообщения
     *
     * @param messageRequest
     */
    void saveMessage(MessageRequest messageRequest);

    /**
     * удаление сообщения по id
     *
     * @param id
     */
    void deleteMessage(Long id);

    /**
     * обновление сообщения по  id
     */
    void updateMessage(Long id, MessageRequest messageRequest);
}
