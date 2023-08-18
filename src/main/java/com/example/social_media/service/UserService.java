package com.example.social_media.service;


import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.UserResponse;

import java.util.List;

public interface UserService {


    /**
     * Получение пользователя по id
     *
     * @return
     */
    UserResponse getUserById(Long id);

    /**
     * Получение списка всех пользователей
     *
     * @return
     */
    List<UserResponse> getAllUsers();

    /**
     * сохранение нового пользователя
     *
     * @param userRequest
     */
    void saveUser(UserRequest userRequest );

    /**
     * удаление пользователя по id
     *
     * @param id
     */
    void deleteUser(Long id);

    /**
     * обновление данных пользователя по его id
     */
    void updateUser(Long id, UserRequest userRequest);

}
