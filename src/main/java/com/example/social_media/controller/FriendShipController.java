package com.example.social_media.controller;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.request.PostRequest;
import com.example.social_media.dto.response.FriendshipResponse;
import com.example.social_media.dto.response.PostResponse;
import com.example.social_media.service.Imp.FriendshipServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Дружба",
        description = "контроллер работы с дружбой пользователей"
)
public class FriendShipController {

    private final FriendshipServiceImp friendshipService;

    /**
     * Получение списка дружбы по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение списка друзей по id пользователя")
    public List<FriendshipResponse> getAllFriendshipByUserId(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return friendshipService.getFriendshipByUserId(id);
    }

    /**
     * сохранение новой дружбы
     * @param friendshipRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение новой дружбы")
    public ResponseEntity<HttpStatus> create(@RequestBody FriendshipRequest friendshipRequest) {

        friendshipService.saveFriendship(friendshipRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление дружбы по id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "удаление дружбы по id")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id дружбы")@PathVariable("id")Long id) {

        friendshipService.deleteFriendship(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
