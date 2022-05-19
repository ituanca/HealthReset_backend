package com.example.healthreset.service;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.RoutineDTO;
import com.example.healthreset.model.dto.RoutineFoodDTO;
import com.example.healthreset.repository.*;
import com.example.healthreset.utils.RoutineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final ActivityLevelRepository activityLevelRepository;
    private final PhysicalExerciseRepository physicalExerciseRepository;
    private final RoutineFoodRepository routineFoodRepository;
    private final PrimaryFoodRepository primaryFoodRepository;
    private final SpecialistRepository specialistRepository;
    private final AdminRepository adminRepository;

    public RoutineService(RoutineRepository routineRepository, ActivityLevelRepository activityLevelRepository, PhysicalExerciseRepository physicalExerciseRepository, RoutineFoodRepository routineFoodRepository, PrimaryFoodRepository primaryFoodRepository, SpecialistRepository specialistRepository, AdminRepository adminRepository) {
        this.routineRepository = routineRepository;
        this.activityLevelRepository = activityLevelRepository;
        this.physicalExerciseRepository = physicalExerciseRepository;
        this.routineFoodRepository = routineFoodRepository;
        this.primaryFoodRepository = primaryFoodRepository;
        this.specialistRepository = specialistRepository;
        this.adminRepository = adminRepository;
    }

    public String createRoutine(RoutineDTO routineDTO) {

        if(!routineDTO.getName().matches("^[a-zA-Z0-9\\-\\s]+$")){
            log.warn(" Name " + routineDTO.getName() + " is not valid!");
            return "name_error";
        }

        RoutineMapper routineMapper = new RoutineMapper();
        Routine routine = routineMapper.convertDTOtoRoutine(routineDTO);

        // fetch activity level from database
        String activityLevelString = routineDTO.getActivityLevel();
        ActivityLevel activityLevel =
                activityLevelRepository.findByActivityLevel(activityLevelString).orElse(null);
        routine.setActivityLevel(activityLevel);

        // fetch physical exercises from database and set
        List<PhysicalExercise> physicalExercises = new ArrayList<PhysicalExercise>();
        for(PhysicalExerciseDTO dto: routineDTO.getListOfPhysicalExercises()){
            PhysicalExercise physicalExercise = physicalExerciseRepository.findByName(dto.getName()).orElse(null);
            physicalExercises.add(physicalExercise);
        }
        routine.setListOfPhysicalExercises(physicalExercises);

        // fetch primary food from database and set
        List<RoutineFood> listOfRoutineFood = new ArrayList<>();
        for(RoutineFoodDTO dto: routineDTO.getListOfFood()){
            PrimaryFood primaryFood = primaryFoodRepository.findByName(dto.getName()).orElse(null);
            listOfRoutineFood.add((RoutineFood) primaryFood);
        }
        routine.setListOfFood(listOfRoutineFood);

        // fetch specialist and set
        specialistRepository.findByUsername(routineDTO.getSpecialist().getUsername()).ifPresent(routine::setSpecialist);

        //fetch admin and set
        adminRepository.findByUsername(routineDTO.getAdmin().getUsername()).ifPresent(routine::setAdmin);

        StatusRoutine statusRoutine = new StatusRoutine("NOT_APPROVED");
        //routine.setStatusRoutine(statusRoutine);

        for(PhysicalExercise p: physicalExercises){
            p.getListOfRoutines().add(routine);
        }

        for(RoutineFood p: listOfRoutineFood){
            p.getListOfRoutines().add(routine);
        }

        routineRepository.save(routine);
        log.info("Routine was created!");

        return "ok";
    }

}
