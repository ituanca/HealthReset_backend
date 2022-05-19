package com.example.healthreset.model.dto;

import com.example.healthreset.model.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineDTO {

    String name;

    String activityLevel;

    List<PhysicalExerciseDTO> listOfPhysicalExercises;

    List<RoutineFoodDTO> listOfFood;

    String description;

    String statusRoutine;

    UserDTO specialist;

    UserDTO admin;

}
