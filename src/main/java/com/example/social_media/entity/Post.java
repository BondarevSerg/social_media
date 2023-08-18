package com.example.social_media.entity;

//import jakarta.persistence.*;
import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.time.LocalDateTime;

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
     * тело поста
     */
    @Column(name = "postmessage")
    private String postMessage;

    /**
     * дата написания поста
     */
    @Column(name = "postdatatime")
    private LocalDateTime date ;

    /**
     * автор поста
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


}
