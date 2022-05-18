package com.example.healthreset.controller;

import com.example.healthreset.model.dto.TrackedActivityDTO;
import com.example.healthreset.service.TrackedActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping(path="/trackedActivity")
public class TrackedActivityController {

    private final TrackedActivityService trackedActivityService;

    public TrackedActivityController(TrackedActivityService trackedActivityService) {
        this.trackedActivityService = trackedActivityService;
    }

    @PostMapping(path = "/create", consumes = {"application/json"})     // post is used when we want to add more resources to our system
    public String createActivity(@RequestBody TrackedActivityDTO trackedActivityDTO) throws URISyntaxException {
        System.out.println(" data entered: " +
                "regular user: " + trackedActivityDTO.getRegularUser().getUsername() + " \n" +
                "date: " + trackedActivityDTO.getDate() + " \n" +
                "nr of steps: " +  trackedActivityDTO.getNrOfSteps() + " \n" +
                "burned calories: " + trackedActivityDTO.getBurnedCalories() + " \n" +
                "eaten calories: " + trackedActivityDTO.getEatenCalories() + " \n" +
                "tracked food: " + trackedActivityDTO.getListOfTrackedFood() + " \n" +
                "tracked exercises: " + trackedActivityDTO.getListOfTrackedExercises());
        return trackedActivityService.createActivity(trackedActivityDTO);
    }

}
