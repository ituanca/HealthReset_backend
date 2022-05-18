package com.example.healthreset.controller;

import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.service.TrackedExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/trackedExercise")
public class TrackedExerciseController {

    private final TrackedExerciseService trackedExerciseService;

    @Autowired
    public TrackedExerciseController(TrackedExerciseService trackedExerciseService) {
        this.trackedExerciseService = trackedExerciseService;
    }

    @GetMapping("/index")
    public List<TrackedExerciseDTO> findAll(){
        return trackedExerciseService.findAll();
    }

}
