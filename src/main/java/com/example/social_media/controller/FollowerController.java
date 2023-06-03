package com.example.social_media.controller;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;
import com.example.social_media.service.Imp.FollowersServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с подписками
 */
@RestController
@RequestMapping("/follower")
@RequiredArgsConstructor
public class FollowerController {

    private final FollowersServiceImp followersService;

    /**
     * Получение списка подписок(входящих) по id пользователя
     *
     * @return
     */
    @GetMapping("/{id}")
    public List<FollowerResponse> getAllFollowerByUserId(@PathVariable("id")Long id) {
        return followersService.getFollowersByUserId(id);
    }

    /**
     * сохранение новой подписки
     * @param followerRequest
     * @return
     */
    @PostMapping()
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
    public ResponseEntity<HttpStatus> delete(@PathVariable("id")Long id) {

        followersService.deleteFollower(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
