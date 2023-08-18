package com.example.social_media.service.Imp;


import com.example.social_media.dto.request.UserRegistrationRequest;
import com.example.social_media.dto.request.UserRequest;
import com.example.social_media.dto.response.UserResponse;
import com.example.social_media.entity.User;
import com.example.social_media.mapper.UserMapper;
import com.example.social_media.repository.UserRepository;
import com.example.social_media.security.UserDetailsImp;
import com.example.social_media.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * сервис работы с пользователем
 */
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {


    private  final UserRepository userRepository;
    private final RoleServiceImp roleService;
    private final  PasswordEncoder passwordEncoder;



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
    /**
     * Получение списка пользователей
     *
     */
    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.MAPPER::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Сохранение (регистрация) нового пользователя(с ролью USER)
     * @return
     */
    @Override
    public void saveUser(UserRegistrationRequest userRegistrationRequest) {

        var user = User.builder()
                .login(userRegistrationRequest.getLogin())
                .password(passwordEncoder.encode(userRegistrationRequest.getPassword()))
                .email(userRegistrationRequest.getEmail())
                .roles(Set.of(roleService.getUserRole()))
                .build();

        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

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

    /**
     * Получение пользователя по логину
     * @param login
     * @return
     */

    public Optional<User> findByLogin(String login) {

        return Optional.ofNullable(userRepository.findByLogin(login));
    }


}
