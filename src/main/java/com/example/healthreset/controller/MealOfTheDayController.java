package com.example.healthreset.controller;

import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.service.MealOfTheDayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/mealOfTheDay")
public class MealOfTheDayController {

    private final MealOfTheDayService mealOfTheDayService;

    @Autowired
    public MealOfTheDayController(MealOfTheDayService mealOfTheDayService) {
        this.mealOfTheDayService = mealOfTheDayService;
    }

    @GetMapping("/index")
    public List<MealOfTheDayDTO> findAll(){
        return mealOfTheDayService.findAll();
    }

}
