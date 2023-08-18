package com.example.social_media.UserServiceImp;

import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.User;
import com.example.social_media.repository.UserRepository;
import com.example.social_media.service.Imp.UserServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    private User testUser;


    @BeforeEach
    void init() {



        testUser = User.builder()
                .id(1L)
                .login("testDriver")
                .password("testPassword")
                .build();
    }


    @Test
    void getDriverById() {

        when(userRepository.findById(anyLong())).thenReturn(Optional.of(testUser));
        UserResponse userResponse = userService.getUserById(testUser.getId());
        assertNotNull(userResponse);
        assertThat(userResponse.getId()).isNotEqualTo(null);
    }
}
