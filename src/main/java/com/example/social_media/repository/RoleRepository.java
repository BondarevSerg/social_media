package com.example.social_media.repository;

import com.example.social_media.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
