package com.example.social_media.repository;

import com.example.social_media.entity.Follower;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower, Long> {

    Follower findFollowerByUserId(Long userId);

    Follower findByUserIdAndFollowerId(Long userId, Long followerId);
    List<Follower> findAllByUserId(Long id);


}
