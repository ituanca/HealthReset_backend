package com.example.healthreset.utils;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.*;

import java.util.ArrayList;
import java.util.List;

public class RoutineMapper {

    public Routine convertDTOtoRoutine(RoutineDTO routineDTO) {
        UsersMapper usersMapper = new UsersMapper();
        Specialist specialist = usersMapper.convertDTOtoSpecialist(routineDTO.getSpecialist());

        return Routine.builder()
                .name(routineDTO.getName())
                .description(routineDTO.getDescription())
                .specialist(specialist)
                .build();
    }

    public RoutineDTO convertRoutineToDTO(Routine routine) {

        RoutineExerciseMapper routineExerciseMapper = new RoutineExerciseMapper();
        List<RoutineExerciseDTO> routineExerciseDTOS = new ArrayList<>();
        for(RoutineExercise r : routine.getListOfPhysicalExercises()){
            routineExerciseDTOS.add(routineExerciseMapper.convertRoutineExerciseToDTO(r));
        }

        RoutineFoodMapper routineFoodMapper = new RoutineFoodMapper();
        List<RoutineFoodDTO> routineFoodDTOS = new ArrayList<>();
        for(RoutineFood f : routine.getListOfFood()){
            routineFoodDTOS.add(routineFoodMapper.convertDTOtoRoutineFood(f));
        }

        return RoutineDTO.builder()
                .name(routine.getName())
                .activityLevel(routine.getActivityLevelRoutine().getActivityLevel())
                .listOfPhysicalExercises(routineExerciseDTOS)
                .listOfFood(routineFoodDTOS)
                .description(routine.getDescription())
                .statusRoutine(routine.getStatusRoutine().getStatusRoutine())
                .specialist(new UsersMapper().convertSpecialistToDTO(routine.getSpecialist()))
                .build();
    }

}
