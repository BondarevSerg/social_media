package com.example.social_media.dto.response;




import lombok.Data;

import java.util.List;


@Data

public class UserResponse {

    /**
     * id
     */
    private Long id;

    /**
     * логин
     */
    private String login;

    /**
     * роль
     */
    private String role;

    /**
     * почта
     */

    private String email;

    /**
     * Список постов
     */

    private List<PostResponse> posts;

    /**
     * список друзей
     */
    private List<FriendshipResponse>  myFriends;

    /**
     * список подписчиков
     */
    private List<FollowerResponse>  myFollowers;

    /**
     * Список входящих заявок
     */

    private List<InviteResponse> myInvitesIn;

    /**
     * Список отправленных заявок
     */

    private List<InviteResponse> myInvitesOut;

    /**
     * Список входящих сообщений
     */

    private List<MessageResponse> myMessageIn;

    /**
     * Список отправленных сообщений
     */

    private List<MessageResponse> myMessageOut;
}
