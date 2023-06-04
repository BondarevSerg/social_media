package com.example.social_media.repository;


import com.example.social_media.entity.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    Friendship findByUserIdAndFriendId(Long  userId,Long friendId);
    List<Friendship> findAllByUserId(Long id);


}
