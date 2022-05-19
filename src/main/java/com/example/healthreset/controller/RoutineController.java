package com.example.healthreset.controller;

import com.example.healthreset.model.Routine;
import com.example.healthreset.model.dto.*;
import com.example.healthreset.service.RoutineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

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

}
