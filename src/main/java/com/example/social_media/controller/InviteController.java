package com.example.social_media.controller;


import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.response.InviteResponse;
import com.example.social_media.service.Imp.InviteServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Заявки",
        description = "контроллер работы с заявками "
)
public class InviteController {

    private final InviteServiceImp inviteService;


    /**
     * Получение заявки по id
     *
     * @return
     */
    @GetMapping("invite/{id}")
    @Operation(summary = "Получение заявки по id")
    public InviteResponse getInvite(@Parameter(description = "id ")@PathVariable("id")Long id) {
        return inviteService.getInviteById(id);
    }
    /**
     * Получение списка заявок(входящих) по id пользователя
     *
     * @return
     */
    @GetMapping("in/{id}")
    @Operation(summary = "Получение списка заявок(входящих) по id пользователя")
    public List<InviteResponse> getAllInvitesIn(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return inviteService.getInvitesInByUserId(id);
    }

    /**
     * Получение списка заявок(исходящих) по id пользователя
     *
     * @return
     */
    @GetMapping("out/{id}")
    @Operation(summary = "Получение списка заявок(исходящих) по id пользователя")
    public List<InviteResponse> getAllInvitesOut(@Parameter(description = "id пользователя")@PathVariable("id")Long id) {
        return inviteService.getInvitesOutByUserId(id);
    }

    /**
     * сохранение новой заявки
     * @param inviteRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение новой заявки")
    public ResponseEntity<HttpStatus> create(@RequestBody InviteRequest inviteRequest) {

        inviteService.saveInvite(inviteRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
