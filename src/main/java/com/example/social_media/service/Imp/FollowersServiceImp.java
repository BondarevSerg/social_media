package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;
import com.example.social_media.entity.Follower;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.FollowerMapper;
import com.example.social_media.repository.FollowerRepository;
import com.example.social_media.service.FollowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FollowersServiceImp implements FollowerService {

    private final FollowerRepository followerRepository;

    @Override
    public List<FollowerResponse> getFollowersByUserId(Long id) {
        return followerRepository.findAllByUserId(id).stream()
                .map(FollowerMapper.MAPPER::toDto).collect(Collectors.toList());
    }

    @Override
    public FollowerResponse getFollowersById(Long id) {

        return FollowerMapper.MAPPER.toDto(followerRepository.findFollowerByUserId(id));
    }

    @Override
    public void saveFollower(FollowerRequest followerRequest) {
               followerRepository.save(FollowerMapper.MAPPER.toEntity(followerRequest));
    }

    @Override
    public void deleteFollower(Long id) {
             followerRepository.deleteById(id);
    }

    @Override
    public void deleteByUserIdAndFollowerId(Long user_id, Long follower_id) {
        var follower =followerRepository.findByUserIdAndFollowerId(follower_id,
                user_id);
        followerRepository.delete(follower);
    }

    @Override
    public void saveByUserIdAndFriendId(Long user_id, Long friend_id) {
        var follower = Follower.builder()
                        .user(User.builder()
                                .id(user_id).build())
                        .follower(User.builder().id(friend_id)
                                .build())
                        .build();

        followerRepository.save(follower);
    }
}
