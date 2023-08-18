package com.example.social_media.entity;

//import jakarta.persistence.*;
import javax.persistence.*;

import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "roles")
//    private Set<User> users;
}
