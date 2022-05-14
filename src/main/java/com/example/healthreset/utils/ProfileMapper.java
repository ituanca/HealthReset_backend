package com.example.healthreset.utils;

import com.example.healthreset.model.Profile;
import com.example.healthreset.model.dto.ProfileDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProfileMapper {
    public Profile convertDTOtoProfile(ProfileDTO profileDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(profileDTO.getBirthdate(), formatter);

        return Profile.builder()
                .weight(profileDTO.getWeight())
                .height(profileDTO.getHeight())
                .birthDate(dateTime)
                .weightGoal(profileDTO.getWeightGoal())
                .nrOfStepsGoal(Integer.parseInt(profileDTO.getNrOfStepsGoal()))
                .build();
    }
}
