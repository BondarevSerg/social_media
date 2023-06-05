package com.example.social_media.service;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.response.FollowerResponse;
import com.example.social_media.dto.response.InviteResponse;

import java.util.List;

public interface InviteService {
    /**
     * получение исходящих заявок по id пользовавтеля
     */
    List<InviteResponse> getInvitesOutByUserId(Long id);
    /**
     * получение входящих заявок по id пользовавтеля
     */
    List<InviteResponse> getInvitesInByUserId(Long id);

    /**
     * получение заявки по id
     */
    InviteResponse getInviteById(Long id);


    /**
     * сохранение новой заявки
     *
     * @param inviteRequest
     */
    void saveInvite(InviteRequest inviteRequest);

    /**
     * удаление заявки по id
     *
     * @param userfrom
     */
    public void deleteInvite(Long userfrom, Long userto);

}
