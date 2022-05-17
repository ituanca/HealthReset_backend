package com.example.healthreset.service;

import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.Profile;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.repository.PhysicalExerciseRepository;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import com.example.healthreset.utils.PhysicalExerciseMapper;
import com.example.healthreset.utils.PrimaryFoodMapper;
import com.example.healthreset.utils.ProfileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        } else if(physicalExerciseDTO.getTypeOfExercise()==null){
            log.warn(" Type was not specified!");
            return "typeOfExercise_error";
        }else if(physicalExerciseDTO.getCaloriesBurnedPerMinute() < 0){
            log.warn(" Number " + physicalExerciseDTO.getCaloriesBurnedPerMinute() + " is not valid!");
            return "calories_error";
        }

        PhysicalExerciseMapper physicalExerciseMapper = new PhysicalExerciseMapper();
        PhysicalExercise physicalExercise =
                physicalExerciseMapper.convertDTOtoPhysicalExercise(physicalExerciseDTO);

        String typeOfExerciseString = physicalExerciseDTO.getTypeOfExercise();
        TypeOfExercise typeOfExercise =
                typeOfExerciseRepository.findByTypeOfExercise(typeOfExerciseString).orElse(null);

        physicalExercise.setTypeOfExercise(typeOfExercise);

        physicalExerciseRepository.save(physicalExercise);
        log.info(" Physical exercise " + physicalExercise.getName() + " successfully added to database!");
        return "ok";
    }

}
