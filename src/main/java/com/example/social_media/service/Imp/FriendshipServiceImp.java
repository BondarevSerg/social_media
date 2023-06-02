package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.response.FriendshipResponse;
import com.example.social_media.entity.Friendship;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.FriendshipMapper;
import com.example.social_media.mapper.PostMapper;
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
//        var friendship = friendshipRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Не найдена дружба по идентификатору: " + id));
//        return FriendshipMapper.MAPPER.toDto(friendship);

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
        friendshipRepository.save(Friendship.builder()
                .user(User.builder()
                        .id(friendshipRequest.getUser_id())
                        .build())
                .friend(User.builder()
                        .id(friendshipRequest.getFriend_id())
                        .build())
                .build());
        //и одновременно сохраняем в БД friend и user, чтобы связать их
        friendshipRepository.save(Friendship.builder()
                .user(User.builder()
                        .id(friendshipRequest.getFriend_id())
                        .build())
                .friend(User.builder()
                        .id(friendshipRequest.getUser_id())
                        .build())
                .build());
    }
    /**
     * удаление  дружбы
     *
     * @param friendshipRequest
     */
    @Override
    public void deleteFriendship(FriendshipRequest friendshipRequest) {

        var friendship1 = friendshipRepository
                .findFriendshipByUserIdAndFriendId(friendshipRequest.getUser_id(),
                        friendshipRequest.getFriend_id());

        var friendship2 = friendshipRepository
                .findFriendshipByUserIdAndFriendId(friendshipRequest.getFriend_id(),
                        friendshipRequest.getUser_id());
        friendshipRepository.delete(friendship1);
        friendshipRepository.delete(friendship2);


    }
}
