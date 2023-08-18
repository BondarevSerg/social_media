package com.example.social_media.entity;

//import jakarta.persistence.*;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Подписка
 */
@Entity
@Table(name = "follower")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Follower {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * пользователь
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    /**
     * его подписчик
     */
    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User follower;

}
