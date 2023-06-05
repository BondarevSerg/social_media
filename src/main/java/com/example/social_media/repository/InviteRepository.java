package com.example.social_media.repository;

import com.example.social_media.entity.Invite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface InviteRepository extends JpaRepository<Invite, Long> {

   List<Invite> findByUserfromId(Long id);

   List<Invite> findByUsertoId(Long id);

   Invite findByUserfromIdAndUsertoId(Long userfrom, Long userto);
}
