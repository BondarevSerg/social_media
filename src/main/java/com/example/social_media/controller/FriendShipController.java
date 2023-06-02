package com.example.social_media.controller;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.response.FriendshipResponse;
import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.service.Imp.FriendshipServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с дружбой пользователей
 */
@RestController
@RequestMapping("/friendship")
@RequiredArgsConstructor
public class FriendShipController {

    private final FriendshipServiceImp friendshipService;

    /**
     * Получение списка дружбы по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    public List<FriendshipResponse> getAllFriendshipByUserId(@PathVariable("id")Long id) {
        return friendshipService.getFriendshipByUserId(id);
    }

    /**
     * сохранение новой дружбы
     * @param friendshipRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody FriendshipRequest friendshipRequest) {

        friendshipService.saveFriendship(friendshipRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление дружбы
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id")Long id) {

        friendshipService.deleteFriendship(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
