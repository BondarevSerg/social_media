package com.example.social_media.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


/**
 * Пользователь
 */

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class User {
    /**
     * id пользователя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Логин
     */
    @Column(name = "login")
    private String login;

    /**
     * пароль
     */
    @Column(name = "password")
    private String password;

    /**
     * роль
     */
    @Column(name = "role")
    private String role;

    /**
     * почта
     */
    @Column(name = "email")
    private String email;

    /**
     * Список постов
     */
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    /**
     * Список друзей
     */
    @OneToMany(mappedBy = "user")
    private List<Friendship> myFriends;

    /**
     * Список подписчиков
     */
    @OneToMany(mappedBy = "user")
    private List<Follower> myFollowers;

    /**
     * Список входящих заявок
     */
    @OneToMany(mappedBy = "userto")
    private List<Invite> myInvitesIn;

    /**
     * Список отправленных заявок
     */
    @OneToMany(mappedBy = "userfrom")
    private List<Invite> myInvitesOut;

    /**
     * Список входящих сообщений
     */
    @OneToMany(mappedBy = "userto")
    private List<Message> myMessageIn;

    /**
     * Список отправленных сщбщений
     */
    @OneToMany(mappedBy = "userfrom")
    private List<Message> myMessageOut;

}
