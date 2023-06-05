package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.request.InviteRequest;
import com.example.social_media.dto.response.InviteResponse;
import com.example.social_media.mapper.InviteMapper;
import com.example.social_media.repository.InviteRepository;
import com.example.social_media.service.InviteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * сервис работы с заявками в друзья
 */
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InviteServiceImp implements InviteService {

    private final InviteRepository inviteRepository;
    private final FollowersServiceImp followersService;
    @Override
    public InviteResponse getInviteById(Long id) {
          var invite = inviteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найдена заявка по идентификатору: " + id));
        return InviteMapper.MAPPER.toDTO(invite);
    }

    @Override
    public List<InviteResponse> getInvitesOutByUserId(Long id) {
        return inviteRepository.findByUserfromId(id).stream()
                .map(InviteMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<InviteResponse> getInvitesInByUserId(Long id) {
        return inviteRepository.findByUsertoId(id).stream()
                .map(InviteMapper.MAPPER::toDTO)
                .collect(Collectors.toList());
    }



    @Override
    public void saveInvite(InviteRequest inviteRequest) {

          inviteRepository.save(InviteMapper.MAPPER.toEntity(inviteRequest));
         //создаем сразу подписку после заявки
        var follower=FollowerRequest.builder()
                .user_id(inviteRequest.getUserto())
                        .follower_id(inviteRequest.getUserfrom())
                .build();
          followersService.saveFollower(follower);
    }

    @Override
    public void deleteInvite(Long userfrom, Long userto) {

        var invite=inviteRepository.findByUserfromIdAndUsertoId(userfrom, userto);
        inviteRepository.delete(invite);
    }
}
