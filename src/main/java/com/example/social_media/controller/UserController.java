package com.example.social_media.controller;

import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.service.Imp.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с пользователем
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final UserServiceImp userService;

    /**
     * Получение списка пользователей
     *
     * @return
     */
    @GetMapping()
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Получение  пользователя по id
     *
     * @return
     */
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable("id")Long id) {
        return userService.getUserById(id);
    }

    /**
     * сохранение нового пользователя
     * @param userRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody UserRequest userRequest) {

        userService.saveUser(userRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * удаление пользователя по id(кроме ADMIN)
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable ("id")Long id) {

        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * обновление  пользователя по id
     * @param id
     * @param userRequest
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable ("id")Long id, UserRequest userRequest) {

        userService.updateUser(id, userRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}
