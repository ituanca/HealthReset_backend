package com.example.healthreset.controller;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.model.dto.PrimaryFoodDTO;
import com.example.healthreset.service.PrimaryFoodService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/primaryFood")
public class PrimaryFoodController {

    private final PrimaryFoodService primaryFoodService;

    public PrimaryFoodController(PrimaryFoodService primaryFoodService) {
        this.primaryFoodService = primaryFoodService;
    }

    @PostMapping(path = "/add", consumes = {"application/json"})     // post is used when we want to add more resources to our system
    public String addPrimaryFood(@RequestBody PrimaryFoodDTO foodDTO) {
        log.info(" name entered: " + foodDTO.getName());
        log.info(" calories entered: " + foodDTO.getCalories());
        log.info(" protein entered: " + foodDTO.getProtein());
        log.info(" fat entered: " + foodDTO.getFat());
        log.info(" sodium entered: " + foodDTO.getSodium());
        return primaryFoodService.addPrimaryFood(foodDTO);
    }

    @GetMapping("/index")
    public List<PrimaryFoodDTO> findAll(){
        return primaryFoodService.findAll();
    }

}
