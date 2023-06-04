package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.response.FriendshipResponse;
import com.example.social_media.entity.Friendship;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.FriendshipMapper;
import com.example.social_media.repository.FollowerRepository;
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

        //сохраняем в БД user и friend
        friendshipRepository.save(friendshipForSave(friendshipRequest.getUser_id()
                ,friendshipRequest.getFriend_id()));
        //и сохраняем в обратном порядке, чтобы связать их
        friendshipRepository.save(friendshipForSave(friendshipRequest.getFriend_id()
                ,friendshipRequest.getUser_id()));


    }
    /**
     * удаление  дружбы  (так же удаляется подписка на бывшего друга)
     *
     * @param friendshipRequest
     */
    @Override
    public void deleteFriendship(FriendshipRequest friendshipRequest) {
          var friendshipUserFriend = friendshipRepository
                  .findByUserIdAndFriendId
                          (friendshipRequest.getUser_id(), friendshipRequest.getFriend_id());

        var friendshipFriendUser = friendshipRepository
                .findByUserIdAndFriendId
                        (friendshipRequest.getFriend_id(), friendshipRequest.getUser_id());

//удаляемся из подписчиков у друга
        followersService.deleteByUserIdAndFollowerId(friendshipRequest.getFriend_id(),
                friendshipRequest.getUser_id());
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
