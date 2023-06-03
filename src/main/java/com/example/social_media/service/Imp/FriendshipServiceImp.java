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
     * удаление  дружбы  по id пользователя
     *
     * @param id
     */
    @Override
    public void deleteFriendship(Long id) {

        var friendship = friendshipRepository
                .findFriendshipByUserId(id);

        friendshipRepository.delete(friendship);
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
