package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.ActivityLevelDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import com.example.healthreset.utils.ActivityLevelMapper;
import com.example.healthreset.utils.TypeOfExerciseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TypeOfExerciseService {

    private final TypeOfExerciseRepository typeOfExerciseRepository;

    @Autowired
    public TypeOfExerciseService(TypeOfExerciseRepository typeOfExerciseRepository) {
        this.typeOfExerciseRepository = typeOfExerciseRepository;
    }

    /**
     * Gets all the types of exercises from the database
     * @return a list of all the type exercises from the database as a list of DTO objects
     */
    public List<TypeOfExerciseDTO> findAll(){
        List<TypeOfExercise> typesOfExercise = typeOfExerciseRepository.findAll();
        List<TypeOfExerciseDTO> typesOfExerciseDTO = new ArrayList<>();
        TypeOfExerciseMapper typeOfExerciseMapper = new TypeOfExerciseMapper();
        for(TypeOfExercise t : typesOfExercise){
            typesOfExerciseDTO.add(typeOfExerciseMapper.convertTypeOfExerciseToDTO(t));
        }
        log.info(" Types of exercise " + typesOfExerciseDTO + " successfully fetched from database!");
        return typesOfExerciseDTO;
    }

}
