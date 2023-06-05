package com.example.social_media.controller;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;
import com.example.social_media.service.Imp.FollowersServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с подписками
 */
@RestController
@RequestMapping("/followers")
@RequiredArgsConstructor
@Tag(
        name = "Подписки",
        description = "Все методы для работы с подписками")
public class FollowerController {

    private final FollowersServiceImp followersService;

    /**
     * Получение списка подписок(входящих) по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение списка подписок(входящих) по id пользователя")
    public List<FollowerResponse> getAllFollowerByUserId(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return followersService.getFollowersByUserId(id);
    }
    /**
     * Получение подписки по id
     *
     * @return
     */
    @GetMapping("/follower/{id}")
    @Operation(summary = "получение подписки по id")
    public FollowerResponse getFollowerById(@Parameter(description = "id подписки")@PathVariable("id")Long id) {
        return followersService.getFollowersById(id);
    }


    /**
     * сохранение новой подписки
     * @param followerRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение новой подписки")
    public ResponseEntity<HttpStatus> create(@RequestBody FollowerRequest followerRequest) {

        followersService.saveFollower(followerRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * удаление подписки
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "удаление подписки по id")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id подписки")@PathVariable("id")Long id) {

        followersService.deleteFollower(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
