package com.example.healthreset.controller;

import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.model.dto.TrackedFoodDTO;
import com.example.healthreset.service.TrackedExerciseService;
import com.example.healthreset.service.TrackedFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/trackedFood")
public class TrackedFoodController {

    private final TrackedFoodService trackedFoodService;

    @Autowired
    public TrackedFoodController(TrackedFoodService trackedExerciseService) {
        this.trackedFoodService = trackedExerciseService;
    }

    @GetMapping("/index")
    public List<TrackedFoodDTO> findAll(){
        return trackedFoodService.findAll();
    }

}
