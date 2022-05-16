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
                .id(profileDTO.getId())
                .weight(profileDTO.getWeight())
                .height(profileDTO.getHeight())
                .birthDate(dateTime)
                .weightGoal(profileDTO.getWeightGoal())
                .nrOfStepsGoal(Integer.parseInt(profileDTO.getNrOfStepsGoal()))
                .build();
    }

    public ProfileDTO convertProfileToDTO(Profile profile) {
        LocalDate dateTime = profile.getBirthDate();
        String formattedDate = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return ProfileDTO.builder()
                .id(profile.getId())
                .weight(profile.getWeight())
                .height(profile.getHeight())
                .birthdate(formattedDate)
                .activityLevel(profile.getActivityLevel().getActivityLevel())
                .weightGoal(profile.getWeightGoal())
                .nrOfStepsGoal(profile.getNrOfStepsGoal().toString())
                .regularUser(new UsersMapper().convertRegularUserToDTO(profile.getRegularUser()))
                .build();
    }
}
