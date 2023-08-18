package com.example.social_media.entity;


import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    /**
     * его друг
     */
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User friend;


}
