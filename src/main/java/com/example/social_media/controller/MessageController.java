package com.example.social_media.controller;


import com.example.social_media.dto.request.MessageRequest;
import com.example.social_media.dto.response.MessageResponse;
import com.example.social_media.service.Imp.MessageServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с заявками
 */
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageServiceImp messageService;

    /**
     * Получение сообщения по id
     * @param id
     * @return
     */
    @GetMapping("message/{id}")
    public MessageResponse getMessage(@PathVariable("id")Long id) {
        return messageService.getMessageById(id);
    }
    /**
     * Получение входящих сообщений по id пользователя
     * @param id
     * @return
     */
    @GetMapping("in/{id}")
    public List<MessageResponse> getAllMessageIn(@PathVariable("id")Long id) {
        return messageService.getAllMessageIn(id);
    }

    /**
     * Получение исходящих сообщений по id пользователя
     * @param id
     * @return
     */
    @GetMapping("out/{id}")
    public List<MessageResponse> getAllMessageOut(@PathVariable("id")Long id) {
        return messageService.getAllMessageOut(id);
    }

    /**
     * сохранение новой заявки
     * @param messageRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody MessageRequest messageRequest) {

        messageService.saveMessage(messageRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление сообщения по id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        messageService.deleteMessage(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * обновление сообщения по id
     * @param id
     * @param messageRequest
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id, MessageRequest messageRequest) {

        messageService.updateMessage(id, messageRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
