package com.example.healthreset.utils;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.*;

import java.util.ArrayList;
import java.util.List;

public class RoutineMapper {

    public Routine convertDTOtoRoutine(RoutineDTO routineDTO) {
        return Routine.builder()
                .name(routineDTO.getName())
                .description(routineDTO.getDescription())
                .build();
    }

//    public RoutineDTO convertRoutineToDTO(Routine routine) {
//        return RoutineDTO.builder()
//                .listOfPhysicalExercises(physicalExercises)
//                .listOfFood(listOfPrimaryFood)
//                .description(routineDTO.getDescription())
//                .specialist(new UsersMapper().convertDTOtoSpecialist(routineDTO.getSpecialist()))
//                .admin(new UsersMapper().convertDTOtoAdmin(routineDTO.getAdmin()))
//                .build();
//    }

}
