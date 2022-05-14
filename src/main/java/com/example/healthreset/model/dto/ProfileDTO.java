package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {

    Double weight;
    Double height;
    String birthdate;
    String activityLevel;
    Double weightGoal;
    String nrOfStepsGoal;
    UserDTO regularUser;
}
