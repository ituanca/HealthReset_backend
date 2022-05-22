package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="email")
    String email;

    @Column(name="username")
    String username;

    @Column(name="password")
    String password;

    public User( String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
