package com.example.social_media.service.Imp;

import com.example.social_media.dto.request.FriendshipRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.Friendship;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.UserMapper;
import com.example.social_media.repository.UserRepository;
import com.example.social_media.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private  final UserRepository userRepository;

    private final FriendshipServiceImp friendshipService;

    /**
     * Получение пользователя по id
     * @param id
     * @return
     */
    @Override
    public UserResponse getUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
        return UserMapper.MAPPER.toDto(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Сохранение нового пользователя(с ролью USER)
     * @return
     */
    @Override

    public void saveUser(UserRequest userRequest) {

        var user = User.builder()
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .email(userRequest.getEmail())
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

//        var user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
//        var frList=user.getMyFriends().stream()
//                        .map(f -> FriendshipRequest.builder()
//                                        .user_id(user.getId())
//                                        .build())
//                            .collect(Collectors.toList());
//
//           for(var fr: frList){
//               friendshipService.deleteFriendship(fr);
//           }
          userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, UserRequest userRequest) {
          var user = userRepository.findById(id)
                  .orElseThrow(() -> new RuntimeException("Не найден пользователь по идентификатору: " + id));
          user.setLogin(user.getLogin());
          user.setPassword(userRequest.getPassword());
          user.setEmail(userRequest.getEmail());
          userRepository.save(user);
    }
}
