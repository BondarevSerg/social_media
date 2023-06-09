package com.example.social_media.service;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;


import java.util.List;

public interface FollowerService {
    /**
     * получение подписок по id пользовавтеля
     */
    List<FollowerResponse> getFollowersByUserId(Long id);

    /**
     * получение подписки по id
     */
    FollowerResponse getFollowersById(Long id);


    /**
     * сохранение новой подписки
     *
     * @param followerRequest
     */
    void saveFollower(FollowerRequest followerRequest);

    /**
     * удаление подписки по id
     *
     * @param id
     */
    void deleteFollower(Long id);
    /**
     * удаление подписки по id пользователя и подписчика

     */
     void deleteByUserIdAndFollowerId(Long user_id, Long follower_id);
    /**
     * сохранение подписки по id пользователя и подписчика

     */
     void saveByUserIdAndFriendId(Long user_id, Long friend_id);
}
