package com.example.social_media.entity;

import jakarta.persistence.*;
import lombok.*;


/**
 * Сообщение
 */
@Entity
@Table(name = "message")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Message {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * сообщение
     */
    @Column(name = "message")
    private String message;

    /**
     * от кого сообщение
     */
    @ManyToOne
    @JoinColumn(name = "userfrom", referencedColumnName = "id")
    private User userfrom;

    /**
     * кому отправлено сообщение
     */
    @ManyToOne
    @JoinColumn(name = "userto", referencedColumnName = "id")
    private User userto;
}
