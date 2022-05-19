package com.example.healthreset.service;

import com.example.healthreset.model.TrackedActivity;
import com.example.healthreset.model.TrackedExercise;
import com.example.healthreset.model.TrackedFood;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.TrackedActivityDTO;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.model.dto.TrackedFoodDTO;
import com.example.healthreset.repository.*;
import com.example.healthreset.utils.TrackedActivityMapper;
import com.example.healthreset.utils.TypeOfExerciseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TrackedActivityService {

    private final TrackedActivityRepository trackedActivityRepository;
    private final RegularUserRepository regularUserRepository;
    private final TrackedExerciseRepository trackedExerciseRepository;
    private final TrackedFoodRepository trackedFoodRepository;

    @Autowired
    public TrackedActivityService(TrackedActivityRepository trackedActivityRepository,
                                  RegularUserRepository regularUserRepository,
                                  TrackedExerciseRepository trackedExerciseRepository,
                                  TrackedFoodRepository trackedFoodRepository) {
        this.trackedActivityRepository = trackedActivityRepository;
        this.regularUserRepository = regularUserRepository;
        this.trackedExerciseRepository = trackedExerciseRepository;
        this.trackedFoodRepository = trackedFoodRepository;
    }

    public String createActivity(TrackedActivityDTO trackedActivityDTO) {
        if(trackedActivityDTO.getNrOfSteps() < 0){
            log.warn(" Number of steps " + trackedActivityDTO.getNrOfSteps() + " is an invalid number!");
            return "invalid_nrOfSteps";
        }

        TrackedActivityMapper trackedActivityMapper = new TrackedActivityMapper();
        TrackedActivity trackedActivity = trackedActivityMapper.convertDTOtoTrackedActivity(trackedActivityDTO);

        if(!trackedActivity.getListOfTrackedExercises().isEmpty()){
            for(TrackedExercise trackedExercise : trackedActivity.getListOfTrackedExercises()){
                trackedExercise.setTrackedActivity(trackedActivity);
            }
            trackedExerciseRepository.saveAll(trackedActivity.getListOfTrackedExercises());
        }
        if(!trackedActivity.getListOfTrackedFood().isEmpty()){
            for(TrackedFood trackedFood: trackedActivity.getListOfTrackedFood()){
                trackedFood.setTrackedActivity(trackedActivity);
            }
            trackedFoodRepository.saveAll(trackedActivity.getListOfTrackedFood());
        }

        regularUserRepository.findByUsername(trackedActivityDTO.getRegularUser().getUsername()).ifPresent(trackedActivity::setRegularUser);

        trackedActivityRepository.save(trackedActivity);
        log.info(" Activity was registered!");

        return "ok";
    }
}
