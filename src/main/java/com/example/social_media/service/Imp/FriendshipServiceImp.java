package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.response.FriendshipResponse;
import com.example.social_media.entity.Friendship;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.FriendshipMapper;
import com.example.social_media.repository.FriendshipRepository;
import com.example.social_media.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис работы дружбы
 */
@Service
@RequiredArgsConstructor
public class FriendshipServiceImp implements FriendshipService {

    private final FriendshipRepository friendshipRepository;

    private final FollowersServiceImp followersService;

    private final InviteServiceImp inviteService;
    @Override
    public List<FriendshipResponse> getFriendshipByUserId(Long id) {

        return friendshipRepository.findAllByUserId(id).stream()
                .map(FriendshipMapper.MAPPER::toDto)
                .collect(Collectors.toList());

    }

    /**
     * сохранение новой дружбы
     *
     * @param friendshipRequest
     */
    @Override
    public void saveFriendship(FriendshipRequest friendshipRequest) {
        //удаляем заявку в друзья
        inviteService.deleteInvite(friendshipRequest.getFriend_id(),
                friendshipRequest.getUser_id());
        //сохраняем в БД user и friend
        friendshipRepository.save(friendshipForSave(friendshipRequest.getUser_id()
                ,friendshipRequest.getFriend_id()));
        // сохраняем в обратном порядке, чтобы связать их
        friendshipRepository.save(friendshipForSave(friendshipRequest.getFriend_id()
                ,friendshipRequest.getUser_id()));
        //подписываемся на инициатора дружбы
        followersService.saveByUserIdAndFriendId(friendshipRequest.getFriend_id()
                ,friendshipRequest.getUser_id());


    }
    /**
     * удаление  дружбы  (так же удаляется подписка на бывшего друга)
     *
     * @param id
     */
    @Override
    public void deleteFriendship(Long id) {

        //нам нужны две сущности для удаления дружбы
          var friendshipUserFriend = friendshipRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Не найдена дружба по идентификатору: " + id));

        var friendshipFriendUser = friendshipRepository
                .findByUserIdAndFriendId
                        (friendshipUserFriend.getFriend().getId(),
                                friendshipUserFriend.getUser().getId());

//удаляемся из подписчиков у друга
        followersService.deleteByUserIdAndFollowerId(friendshipUserFriend.getFriend().getId(), friendshipUserFriend.getUser().getId());
        //и удаляем дружбу
        friendshipRepository.delete(friendshipUserFriend);
        friendshipRepository.delete(friendshipFriendUser);

    }

    //вынес в отдельный метод билдер по id
    protected Friendship friendshipForSave(Long idUser, Long idFriend){
        return Friendship.builder()
                 .user(User.builder()
                         .id(idUser)
                         .build())
                .friend(User.builder()
                        .id(idFriend)
                        .build())
                .build();
    }
}
