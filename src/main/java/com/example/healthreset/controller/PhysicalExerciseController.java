package com.example.healthreset.controller;

import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.service.PhysicalExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/physicalExercise")
public class PhysicalExerciseController {

    private final PhysicalExerciseService physicalExerciseService;

    @Autowired
    public PhysicalExerciseController(PhysicalExerciseService physicalExerciseService) {
        this.physicalExerciseService = physicalExerciseService;
    }

    @PostMapping(path = "/add", consumes = {"application/json"})     // post is used when we want to add more resources to our system
    public String addPhysicalExercise(@RequestBody PhysicalExerciseDTO physicalExerciseDTO) {
        log.info(" name entered: " + physicalExerciseDTO.getName());
        log.info(" calories entered: " + physicalExerciseDTO.getCaloriesBurnedPerMinute());
        log.info(" protein entered: " + physicalExerciseDTO.getTypeOfExercise());
        return physicalExerciseService.addPhysicalExercise(physicalExerciseDTO);
    }

    @GetMapping("/index")
    public List<PhysicalExerciseDTO> findAll(){
        return physicalExerciseService.findAll();
    }

}
