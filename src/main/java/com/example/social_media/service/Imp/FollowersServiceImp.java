package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FollowerRequest;
import com.example.social_media.dto.response.FollowerResponse;
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
}
