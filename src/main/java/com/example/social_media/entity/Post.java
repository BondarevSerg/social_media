package com.example.social_media.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Пост пользователя
 */

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Post {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Сообщение(содержимое поста)
     */
    @Column(name = "message")
    private String message;

    /**
     * автор поста
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
