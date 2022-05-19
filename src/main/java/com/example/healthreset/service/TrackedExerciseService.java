package com.example.healthreset.service;

import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.TrackedExercise;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.repository.PhysicalExerciseRepository;
import com.example.healthreset.repository.TrackedExerciseRepository;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import com.example.healthreset.utils.TrackedExerciseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TrackedExerciseService {

    private final TrackedExerciseRepository trackedExerciseRepository;
    private final PhysicalExerciseRepository physicalExerciseRepository;
    private final TypeOfExerciseRepository typeOfExerciseRepository;

    @Autowired
    public TrackedExerciseService(TrackedExerciseRepository trackedExerciseRepository, PhysicalExerciseRepository physicalExerciseRepository, TypeOfExerciseRepository typeOfExerciseRepository) {
        this.trackedExerciseRepository = trackedExerciseRepository;
        this.physicalExerciseRepository = physicalExerciseRepository;
        this.typeOfExerciseRepository = typeOfExerciseRepository;
    }

    public List<TrackedExerciseDTO> findAll(){
        List<PhysicalExercise> physicalExercises = physicalExerciseRepository.findAll();
        List<TrackedExerciseDTO> trackedExercisesDTOS = new ArrayList<>();

        TrackedExerciseMapper trackedExerciseMapper = new TrackedExerciseMapper();
        for(PhysicalExercise physicalExercise : physicalExercises) {
            TrackedExercise trackedExercise = new TrackedExercise();
            trackedExercise.setName(physicalExercise.getName());
            trackedExercise.setCaloriesBurnedPerMinute(physicalExercise.getCaloriesBurnedPerMinute());
            trackedExercise.setTypeOfExercise(physicalExercise.getTypeOfExercise());
            trackedExercisesDTOS.add(trackedExerciseMapper.convertTrackedExerciseToDTO(trackedExercise));
        }
        log.info(" Tracked exercises " + trackedExercisesDTOS + " successfully fetched!");
        return trackedExercisesDTOS;
    }

}
