package com.example.healthreset.controller;

import com.example.healthreset.model.Routine;
import com.example.healthreset.model.dto.*;
import com.example.healthreset.service.RoutineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path="/routine")
public class RoutineController {

    private final RoutineService routineService;

    public RoutineController(RoutineService routineService) {
        this.routineService = routineService;
    }

    @PostMapping(path = "/create", consumes = {"application/json"})     // post is used when we want to add more resources to our system
    public String createRoutine(@RequestBody RoutineDTO routineDTO) throws URISyntaxException {
        log.info(" data entered: " +
                "activity level: " + routineDTO.getActivityLevel() + " " +
                "exercises: " + routineDTO.getListOfPhysicalExercises() + " " +
                "food: " + routineDTO.getListOfFood() + " " +
                "description: " + routineDTO.getDescription() + " " +
                "status: " + routineDTO.getStatusRoutine() + " " +
                "specialist: " + routineDTO.getSpecialist().getUsername() + " " +
                "admin: " + routineDTO.getAdmin());
        return routineService.createRoutine(routineDTO);
    }

    @GetMapping("/checkIfExists")
    public String checkIfExists(@Param("admin") String name){
        log.info(" name entered: " + name);
        return routineService.checkIfNameExists(name);
    }

    @GetMapping("/index")
    public List<RoutineDTO> findAll(){
        List<RoutineDTO> routineDTOS = routineService.findAll();
        for(RoutineDTO r : routineDTOS){
            log.info(" data fetched: " +
                    "activity level: " + r.getActivityLevel() + " " +
                    "exercises: " + r.getListOfPhysicalExercises() + " " +
                    "food: " + r.getListOfFood() + " " +
                    "description: " + r.getDescription() + " " +
                    "status: " + r.getStatusRoutine() + " " +
                    "specialist: " + r.getSpecialist().getUsername() + " " +
                    "admin: " + r.getAdmin());
        }
        return routineDTOS;
    }

    @PutMapping(value = "/updateStatus", consumes = {"application/json"})
    public String updateStatus( @RequestBody RoutineDTO routineDTO){
        log.info(" data entered: " + routineDTO);
        return routineService.updateStatus(routineDTO);
    }

    @GetMapping("/indexApproved")
    public List<RoutineDTO> findApprovedRoutines(){
        List<RoutineDTO> routineDTOS = routineService.findApprovedRoutines();
        for(RoutineDTO r : routineDTOS){
            log.info(" data fetched: " +
                    "activity level: " + r.getActivityLevel() + " " +
                    "exercises: " + r.getListOfPhysicalExercises() + " " +
                    "food: " + r.getListOfFood() + " " +
                    "description: " + r.getDescription() + " " +
                    "status: " + r.getStatusRoutine() + " " +
                    "specialist: " + r.getSpecialist().getUsername() + " " +
                    "admin: " + r.getAdmin());
        }
        return routineDTOS;
    }

}
