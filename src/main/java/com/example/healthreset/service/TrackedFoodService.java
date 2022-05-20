package com.example.healthreset.service;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.TrackedFood;
import com.example.healthreset.model.dto.TrackedFoodDTO;
import com.example.healthreset.repository.PrimaryFoodRepository;
import com.example.healthreset.repository.TrackedExerciseRepository;
import com.example.healthreset.utils.TrackedFoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TrackedFoodService {

    private final TrackedExerciseRepository trackedExerciseRepository;
    private final PrimaryFoodRepository primaryFoodRepository;

    public TrackedFoodService(TrackedExerciseRepository trackedExerciseRepository, PrimaryFoodRepository primaryFoodRepository) {
        this.trackedExerciseRepository = trackedExerciseRepository;
        this.primaryFoodRepository = primaryFoodRepository;
    }

    public List<TrackedFoodDTO> findAll(){
        List<PrimaryFood> primaryFoodList = primaryFoodRepository.findAll();
        List<TrackedFoodDTO> trackedFoodDTOS = new ArrayList<>();

        TrackedFoodMapper trackedFoodMapper = new TrackedFoodMapper();
        for(PrimaryFood primaryFood : primaryFoodList) {
            TrackedFood trackedFood = new TrackedFood();
            trackedFood.setName(primaryFood.getName());
            trackedFood.setCalories(primaryFood.getCalories());
            trackedFood.setProtein(primaryFood.getProtein());
            trackedFood.setFat(primaryFood.getFat());
            trackedFood.setSodium(primaryFood.getSodium());
            trackedFood.setQuantity(primaryFood.getQuantity());
            trackedFoodDTOS.add(trackedFoodMapper.convertTrackedFoodToDTO(trackedFood));
        }
        System.out.println("oij98uhy7g34uh2ij90ervf8uhr3u4");
        log.info(" Tracked food " + trackedFoodDTOS + " successfully fetched!");
        return trackedFoodDTOS;
    }


}
