package com.example.social_media.service;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.response.FriendshipResponse;

import java.util.List;


public interface FriendshipService {

    /**
     * получение дружбы по id пользовавтеля
     */
     List<FriendshipResponse> getFriendshipByUserId(Long id);


    /**
     * сохранение новой дружбы
     *
     * @param friendshipRequest
     */
    void saveFriendship(FriendshipRequest friendshipRequest);

    /**
     * удаление дружбы
     *
     * @param id
     */
    void deleteFriendship(Long id);


}
