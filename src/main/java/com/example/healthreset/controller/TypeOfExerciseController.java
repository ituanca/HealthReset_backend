package com.example.healthreset.controller;

import com.example.healthreset.model.dto.ActivityLevelDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;
import com.example.healthreset.service.TypeOfExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/typeOfExercise")
public class TypeOfExerciseController {

    private final TypeOfExerciseService typeOfExerciseService;

    @Autowired
    public TypeOfExerciseController(TypeOfExerciseService typeOfExerciseService) {
        this.typeOfExerciseService = typeOfExerciseService;
    }

    @GetMapping("/index")
    public List<TypeOfExerciseDTO> findAll(){
        return typeOfExerciseService.findAll();
    }
}
