package com.example.healthreset.utils;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.Specialist;
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
        if(regularUserDTO.getPassword() != null){
            regularUser.setPassword(new BCryptPasswordEncoder().encode(regularUserDTO.getPassword()));
        }
        return regularUser;
    }

    public UserDTO convertRegularUserToDTO(RegularUser regularUser){
        return UserDTO.builder()
                .name(regularUser.getName())
                .email(regularUser.getEmail())
                .username(regularUser.getUsername())
                .build();
    }

    public Specialist convertDTOtoSpecialist(UserDTO specialistDTO){
        Specialist specialist = Specialist.builder()
                .name(specialistDTO.getName())
                .build();
        specialist.setEmail(specialistDTO.getEmail());
        specialist.setUsername(specialistDTO.getUsername());
        specialist.setPassword(new BCryptPasswordEncoder().encode(specialistDTO.getPassword()));
        return specialist;
    }

}
