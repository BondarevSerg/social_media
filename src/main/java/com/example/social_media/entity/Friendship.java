package com.example.social_media.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Дружба
 */
@Entity
@Table(name = "friendship")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Friendship {


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
    private User user;

    /**
     * его друг
     */
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private User friend;


}
