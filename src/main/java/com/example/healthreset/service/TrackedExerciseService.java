package com.example.healthreset.service;

import com.example.healthreset.model.Exercise;
import com.example.healthreset.model.TrackedExercise;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.repository.ExerciseRepository;
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
    private final ExerciseRepository exerciseRepository;
    private final TypeOfExerciseRepository typeOfExerciseRepository;

    @Autowired
    public TrackedExerciseService(TrackedExerciseRepository trackedExerciseRepository, ExerciseRepository exerciseRepository, TypeOfExerciseRepository typeOfExerciseRepository) {
        this.trackedExerciseRepository = trackedExerciseRepository;
        this.exerciseRepository = exerciseRepository;
        this.typeOfExerciseRepository = typeOfExerciseRepository;
    }

    /**
     * Gets all the tracked exercises from the database
     * @return a list of all the tracked exercises found in the database, as a list of DTO objects
     */
    public List<TrackedExerciseDTO> findAll(){
        List<Exercise> exercises = exerciseRepository.findAll();
        List<TrackedExerciseDTO> trackedExercisesDTOS = new ArrayList<>();

        TrackedExerciseMapper trackedExerciseMapper = new TrackedExerciseMapper();
        for(Exercise exercise : exercises) {
            TrackedExercise trackedExercise = new TrackedExercise();
            trackedExercise.setName(exercise.getName());
            trackedExercise.setCaloriesBurnedPerMinute(exercise.getCaloriesBurnedPerMinute());
            trackedExercise.setTypeOfExercise(exercise.getTypeOfExercise());
            trackedExercisesDTOS.add(trackedExerciseMapper.convertTrackedExerciseToDTO(trackedExercise));
        }
        log.info(" Tracked exercises " + trackedExercisesDTOS + " successfully fetched!");
        return trackedExercisesDTOS;
    }

}
