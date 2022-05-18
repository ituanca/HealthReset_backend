package com.example.healthreset.controller;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.PrimaryFoodDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;
import com.example.healthreset.service.PhysicalExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public PhysicalExerciseDTO findByName(@PathVariable String name){
        log.info(" id entered: " + name);
        return physicalExerciseService.findByName(name);
    }

}
