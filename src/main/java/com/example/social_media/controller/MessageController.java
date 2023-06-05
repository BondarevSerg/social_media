package com.example.social_media.controller;


import com.example.social_media.dto.request.MessageRequest;
import com.example.social_media.dto.response.MessageResponse;
import com.example.social_media.service.Imp.MessageServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с сообщениями
 */
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
@Tag(
        name = "Сообщения",
        description = "контроллер работы с сообщениями"
)
public class MessageController {

    private final MessageServiceImp messageService;

    /**
     * Получение сообщения по id
     * @param id
     * @return
     */

    @GetMapping("message/{id}")
    @Operation(summary = "Получение сообщения по id")
    public MessageResponse getMessage(@Parameter(description = "id сообщения")@PathVariable("id")Long id) {
        return messageService.getMessageById(id);
    }
    /**
     * Получение входящих сообщений по id пользователя
     * @param id
     * @return
     */
    @GetMapping("in/{id}")
    @Operation(summary = "Получение входящих сообщений по id пользователя")
    public List<MessageResponse> getAllMessageIn(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return messageService.getAllMessageIn(id);
    }

    /**
     * Получение исходящих сообщений по id пользователя
     * @param id
     * @return
     */
    @GetMapping("out/{id}")
    @Operation(summary = "Получение исходящих сообщений по id пользователя")
    public List<MessageResponse> getAllMessageOut(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return messageService.getAllMessageOut(id);
    }

    /**
     * сохранение нового сообщения
     * @param messageRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение нового сообщения")
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
    @Operation(summary = "удаление сообщения по id")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id сообщения")@PathVariable ("id")Long id) {

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
    @Operation(summary = "обновление сообщения по id")
    public ResponseEntity<HttpStatus> update(@Parameter(description = "id сообщения")@PathVariable ("id")Long id, MessageRequest messageRequest) {

        messageService.updateMessage(id, messageRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

}
