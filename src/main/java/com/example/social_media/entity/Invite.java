package com.example.social_media.entity;

//import jakarta.persistence.*;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Заявка в друзья
 */
@Entity
@Table(name = "invite")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")

public class Invite {
    /**
     * id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * от кого заявка
     */
    @ManyToOne
    @JoinColumn(name = "userfrom", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userfrom;

    /**
     * кому отправлена заявка
     */
    @ManyToOne
    @JoinColumn(name = "userto", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userto;
}
