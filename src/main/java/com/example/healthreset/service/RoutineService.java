package com.example.healthreset.service;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.*;
import com.example.healthreset.repository.*;
import com.example.healthreset.utils.RoutineMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RoutineService {

    private final RoutineRepository routineRepository;
    private final ActivityLevelRepository activityLevelRepository;
    private final ExerciseRepository exerciseRepository;
    private final PhysicalExerciseRepository physicalExerciseRepository;
    private final RoutineFoodRepository routineFoodRepository;
    private final PrimaryFoodRepository primaryFoodRepository;
    private final SpecialistRepository specialistRepository;
    private final AdminRepository adminRepository;
    private final StatusRoutineRepository statusRoutineRepository;

    public RoutineService(RoutineRepository routineRepository, ActivityLevelRepository activityLevelRepository, ExerciseRepository exerciseRepository, PhysicalExerciseRepository physicalExerciseRepository, RoutineFoodRepository routineFoodRepository, PrimaryFoodRepository primaryFoodRepository, SpecialistRepository specialistRepository, AdminRepository adminRepository, StatusRoutineRepository statusRoutineRepository) {
        this.routineRepository = routineRepository;
        this.activityLevelRepository = activityLevelRepository;
        this.exerciseRepository = exerciseRepository;
        this.physicalExerciseRepository = physicalExerciseRepository;
        this.routineFoodRepository = routineFoodRepository;
        this.primaryFoodRepository = primaryFoodRepository;
        this.specialistRepository = specialistRepository;
        this.adminRepository = adminRepository;
        this.statusRoutineRepository = statusRoutineRepository;
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

        routine.setActivityLevelRoutine(activityLevel);

        // fetch physical exercises from database and set
        List<RoutineExercise> routineExercises = new ArrayList<>();
        for(RoutineExerciseDTO dto: routineDTO.getListOfPhysicalExercises()){
            PhysicalExercise physicalExercise = physicalExerciseRepository.findByName(dto.getName()).orElse(null);
            if(physicalExercise != null){
                RoutineExercise routineExercise = new RoutineExercise();

                routineExercise.setName(physicalExercise.getName());
                routineExercise.setTypeOfExercise(physicalExercise.getTypeOfExercise());
                routineExercise.setCaloriesBurnedPerMinute(physicalExercise.getCaloriesBurnedPerMinute());

                routineExercises.add(routineExercise);
            }
        }
        routine.setListOfPhysicalExercises(routineExercises);

        // fetch primary food from database and set as routine food
        List<RoutineFood> listOfRoutineFood = new ArrayList<>();
        for(RoutineFoodDTO dto: routineDTO.getListOfFood()){
            PrimaryFood primaryFood = primaryFoodRepository.findByName(dto.getName()).orElse(null);
            if(primaryFood!=null){
                RoutineFood routineFood = new RoutineFood();

                routineFood.setName(primaryFood.getName());
                routineFood.setCalories(primaryFood.getCalories());
                routineFood.setQuantity(primaryFood.getQuantity());
                routineFood.setFat(primaryFood.getFat());
                routineFood.setProtein(primaryFood.getProtein());
                routineFood.setSodium(primaryFood.getSodium());
                routineFood.setMealOfTheDay(dto.getMealOfTheDay());

                listOfRoutineFood.add(routineFood);
            }
        }
        routine.setListOfFood(listOfRoutineFood);

        // fetch specialist and set
        specialistRepository.findByUsername(routineDTO.getSpecialist().getUsername()).ifPresent(routine::setSpecialist);

        //fetch admin and set
        if(routineDTO.getAdmin()!=null){
            adminRepository.findByUsername(routineDTO.getAdmin().getUsername()).ifPresent(routine::setAdmin);
        }

        StatusRoutine statusRoutine = statusRoutineRepository.findByStatusRoutine("NOT APPROVED").orElse(null);
        routine.setStatusRoutine(statusRoutine);

        for(RoutineExercise p: routineExercises){
            if(p.getListOfRoutines()!=null){
                p.getListOfRoutines().add(routine);
            }
        }

        for(RoutineFood p: listOfRoutineFood){
            if(p.getListOfRoutines()!=null){
                p.getListOfRoutines().add(routine);
            }
        }

        routineRepository.save(routine);
        log.info("Routine was created!");

        return "ok";
    }

    public String checkIfNameExists(String name){
        Optional<Routine> routine = routineRepository.findByName(name);
        if(routine.isEmpty()){
            log.warn(" Routine with name " + name + " was not found!");
        }else{
            log.info(" Routine with name " + name + " was found!");
            return "name_exists";
        }
        return "ok";
    }

    public List<RoutineDTO> findAll(){
        List<Routine> routines = routineRepository.findAll();
        List<RoutineDTO> routineDTOS = new ArrayList<>();
        RoutineMapper routineMapper = new RoutineMapper();
        for(Routine a : routines){
            routineDTOS.add(routineMapper.convertRoutineToDTO(a));
        }
        log.info(" Routines " + routineDTOS + " successfully fetched from database!");
        return routineDTOS;
    }

    public String updateStatus(RoutineDTO routineDTO){

        StatusRoutine statusRoutine = statusRoutineRepository.findByStatusRoutine(routineDTO.getStatusRoutine()).orElse(null);

        if(statusRoutine != null){
            routineRepository.findByName(routineDTO.getName())
                    .map(routine -> {
                        routine.setStatusRoutine(statusRoutine);
                        return routineRepository.save(routine);
                    });
            return "updated";
        }
        return "not_updated";
    }

    public List<RoutineDTO> findApprovedRoutines(){
        List<Routine> routines = routineRepository.findAll();
        List<RoutineDTO> routineDTOS = new ArrayList<>();
        RoutineMapper routineMapper = new RoutineMapper();
        for(Routine a : routines){
            StatusRoutine statusRoutine = new StatusRoutine();
            statusRoutine = statusRoutineRepository.findByStatusRoutine("APPROVED").orElse(null);
            if(a.getStatusRoutine().equals(statusRoutine)){
                routineDTOS.add(routineMapper.convertRoutineToDTO(a));
            }
        }
        log.info(" Routines " + routineDTOS + " successfully fetched from database!");
        return routineDTOS;
    }

}
