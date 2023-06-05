package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.MessageRequest;
import com.example.social_media.dto.response.MessageResponse;

import com.example.social_media.mapper.MessageMapper;
import com.example.social_media.repository.MessageRepository;
import com.example.social_media.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис работы с сообщениями
 */

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository;

    /**
     *
     * @param id
     * @return
     */
    @Override
    public MessageResponse getMessageById(Long id) {
        var message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено сообщение по идентификатору: " + id));
        return MessageMapper.MAPPER.toDTO(message);

    }

    /**
     * получение входящих сообщений
     * @param id
     * @return
     */
    @Override
    public List<MessageResponse> getAllMessageIn(Long id) {
        return messageRepository.findAllByUsertoId(id).stream()
                .map(MessageMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }
    /**
     * получение исходящих сообщений
     * @param id
     * @return
     */
    @Override
    public List<MessageResponse> getAllMessageOut(Long id) {
        return messageRepository.findAllByUserfromId(id).stream()
                .map(MessageMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * сохранение сообщение
     * @param messageRequest
     */
    @Override
    public void saveMessage(MessageRequest messageRequest) {
          messageRepository.save(MessageMapper.MAPPER.toEntity(messageRequest));
    }

    /**
     * удаление сообщения
     * @param id
     */
    @Override
    public void deleteMessage(Long id) {
      messageRepository.deleteById(id);
    }

    /**
     * обновление сообщения(только текст)
     * @param id
     * @param messageRequest
     */
    @Override
    public void updateMessage(Long id, MessageRequest messageRequest) {
        var message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдено сообщение по идентификатору: " + id));
        message.setMessage(messageRequest.getMessage());
        messageRepository.save(message);
    }
}
