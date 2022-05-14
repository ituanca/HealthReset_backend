package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="email")
    String email;

    @Column(name="username")
    String username;

    @Column(name="password")
    String password;
}
