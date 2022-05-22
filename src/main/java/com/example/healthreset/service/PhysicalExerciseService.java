package com.example.healthreset.service;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.repository.ExerciseRepository;
import com.example.healthreset.repository.PhysicalExerciseRepository;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import com.example.healthreset.utils.PhysicalExerciseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PhysicalExerciseService {

    private final PhysicalExerciseRepository physicalExerciseRepository;
    private final TypeOfExerciseRepository typeOfExerciseRepository;

    @Autowired
    public PhysicalExerciseService(PhysicalExerciseRepository physicalExerciseRepository, TypeOfExerciseRepository typeOfExerciseRepository) {
        this.physicalExerciseRepository = physicalExerciseRepository;
        this.typeOfExerciseRepository = typeOfExerciseRepository;
    }

    public String addPhysicalExercise(PhysicalExerciseDTO physicalExerciseDTO) {

        if(!physicalExerciseDTO.getName().matches("^[a-zA-Z0-9\\-\\s]+$")){
            log.warn(" Name " + physicalExerciseDTO.getName() + " is not valid!");
            return "name_error";
        } else if(physicalExerciseRepository.findByName(physicalExerciseDTO.getName()).isPresent() ){
            log.warn(" Exercise " + physicalExerciseDTO.getName() + " already exists!");
            return "exercise_exists";
        }else if(physicalExerciseDTO.getTypeOfExercise()==null){
            log.warn(" Type was not specified!");
            return "typeOfExercise_error";
        }else if(physicalExerciseDTO.getCaloriesBurnedPerMinute() < 0){
            log.warn(" Number " + physicalExerciseDTO.getCaloriesBurnedPerMinute() + " is not valid!");
            return "calories_error";
        }

        PhysicalExerciseMapper physicalExerciseMapper = new PhysicalExerciseMapper();
        PhysicalExercise physicalExercise =
                physicalExerciseMapper.convertDTOtoPhysicalExercise(physicalExerciseDTO);

        TypeOfExercise typeOfExercise = typeOfExerciseRepository.findByTypeOfExercise(physicalExerciseDTO.getTypeOfExercise().getTypeOfExercise()).orElse(null);

        physicalExercise.setTypeOfExercise(typeOfExercise);

        physicalExerciseRepository.save(physicalExercise);
        log.info(" Physical physicalExercise " + physicalExercise.getName() + " successfully added to database!");
        return "ok";
    }

    public List<PhysicalExerciseDTO> findAll(){
        List<PhysicalExercise> physicalExercises = physicalExerciseRepository.findAll();
        List<PhysicalExerciseDTO> physicalExerciseDTOS = new ArrayList<>();
        PhysicalExerciseMapper physicalExerciseMapper = new PhysicalExerciseMapper();
        for(PhysicalExercise t : physicalExercises){
            if(t.getTypeOfExercise()!=null){
                physicalExerciseDTOS.add(physicalExerciseMapper.convertPhysicalExerciseToDTO(t));
            }
        }
        log.info(" Types of exercise " + physicalExerciseDTOS + " successfully fetched from database!");
        return physicalExerciseDTOS;
    }


}
