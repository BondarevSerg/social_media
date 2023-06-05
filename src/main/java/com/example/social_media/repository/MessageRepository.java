package com.example.social_media.repository;

import com.example.social_media.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {


    List<Message> findAllByUsertoId(Long usertoId);

    List<Message> findAllByUserfromId(Long userfromId);
}
