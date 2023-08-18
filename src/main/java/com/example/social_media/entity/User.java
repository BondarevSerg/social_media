package com.example.social_media.entity;

import javax.persistence.*;

import lombok.*;

import java.util.List;
import java.util.Set;


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

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "user_roles",joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;
}
