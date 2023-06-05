package com.example.social_media.controller;


import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.response.InviteResponse;
import com.example.social_media.service.Imp.InviteServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * контроллер работы с заявками
 */
@RestController
@RequestMapping("/invites")
@RequiredArgsConstructor
public class InviteController {

    private final InviteServiceImp inviteService;


    /**
     * Получение заявки по id
     *
     * @return
     */
    @GetMapping("invite/{id}")
    public InviteResponse getInvite(@PathVariable("id")Long id) {
        return inviteService.getInviteById(id);
    }
    /**
     * Получение списка заявок(входящих) по id пользователя
     *
     * @return
     */
    @GetMapping("in/{id}")
    public List<InviteResponse> getAllInvitesIn(@PathVariable("id")Long id) {
        return inviteService.getInvitesInByUserId(id);
    }

    /**
     * Получение списка заявок(исходящих) по id пользователя
     *
     * @return
     */
    @GetMapping("out/{id}")
    public List<InviteResponse> getAllInvitesOut(@PathVariable("id")Long id) {
        return inviteService.getInvitesOutByUserId(id);
    }

    /**
     * сохранение новой заявки
     * @param inviteRequest
     * @return
     */
    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody InviteRequest inviteRequest) {

        inviteService.saveInvite(inviteRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
