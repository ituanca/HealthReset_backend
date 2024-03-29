package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {

    String name;
    String email;
    String username;
    String password;

    public UserDTO(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
