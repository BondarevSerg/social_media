package com.example.social_media.controller;

import com.example.social_media.dto.request.UserRegistrationRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.service.Imp.UserServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * контроллер работы с пользователем
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(
        name = "Пользователь",
        description = "контроллер работы с пользователем"
)
public class UserController {

    private  final UserServiceImp userService;

    /**
     * Получение списка пользователей
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = "Получение списка пользователей")
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Получение  пользователя по id
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение  пользователя по id")
    public UserResponse getUserById(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return userService.getUserById(id);
    }

    /**
     * регистрация нового пользователя
     * @param userRegistrationRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "регистрация нового пользователя")
    public ResponseEntity<HttpStatus> create(@RequestBody UserRegistrationRequest userRegistrationRequest) {

        userService.saveUser(userRegistrationRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * удаление пользователя по id
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "удаление пользователя по id")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id пользователя")@PathVariable ("id")Long id) {

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
    @Operation(summary = "обновление  пользователя по id")
    public ResponseEntity<HttpStatus> update(@Parameter(description = "id пользователя")@PathVariable ("id")Long id, UserRequest userRequest) {

        userService.updateUser(id, userRequest);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    /**
     * информация  о текущем пользователе
     * @param principal
     * @return
     */
    @GetMapping("/info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
