package com.example.social_media.service.Imp;

import com.example.social_media.entity.Role;
import com.example.social_media.repository.RoleRepository;
import com.example.social_media.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER");
    }
}
