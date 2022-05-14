package com.example.healthreset.utils;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersMapper {

    public Admin convertDTOtoAdmin(UserDTO userDTO){
        Admin admin = Admin.builder()
                .build();
        admin.setEmail(userDTO.getEmail());
        admin.setUsername(userDTO.getUsername());
        admin.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        return admin;
    }

    public RegularUser convertDTOtoRegularUser(UserDTO regularUserDTO){
        RegularUser regularUser = RegularUser.builder()
                .name(regularUserDTO.getName())
                .build();
        regularUser.setEmail(regularUserDTO.getEmail());
        regularUser.setUsername(regularUserDTO.getUsername());
        regularUser.setPassword(new BCryptPasswordEncoder().encode(regularUserDTO.getPassword()));
        return regularUser;
    }

}
