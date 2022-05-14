package com.example.healthreset.service;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.dto.PrimaryFoodDTO;
import com.example.healthreset.repository.PrimaryFoodRepository;
import com.example.healthreset.utils.PrimaryFoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrimaryFoodService {

    @Autowired
    PrimaryFoodRepository primaryFoodRepository;

    public String addPrimaryFood(PrimaryFoodDTO foodDTO) {

        if(!foodDTO.getName().matches("^[a-zA-Z0-9\\-\\s]+$")){
            log.warn(" Name " + foodDTO.getName() + " is not valid!");
            return "name_error";
        } else if(Integer.parseInt(foodDTO.getCalories()) < 0){
            log.warn(" Calories " + foodDTO.getCalories() + " is not valid!");
            return "calories_error";
        }else if(Integer.parseInt(foodDTO.getProtein()) < 0){
            log.warn(" Protein " + foodDTO.getProtein() + " is not valid!");
            return "protein_error";
        }else if(Integer.parseInt(foodDTO.getFat()) < 0){
            log.warn(" Fat " + foodDTO.getFat() + " is not valid!");
            return "fat_error";
        } else if(Integer.parseInt(foodDTO.getSodium()) < 0){
            log.warn(" Sodium " + foodDTO.getSodium() + " is not valid!");
            return "sodium_error";
        } else if(Integer.parseInt(foodDTO.getQuantity()) < 0){
            log.warn(" Quantity " + foodDTO.getQuantity() + " is not valid!");
            return "quantity_error";
        }

        PrimaryFoodMapper primaryFoodMapper = new PrimaryFoodMapper();
        PrimaryFood food = primaryFoodMapper.convertDTOtoPrimaryFood(foodDTO);

        log.info(" Food " + food.getName() + " successfully added to menu!");
        primaryFoodRepository.save(food);
        return "ok";
    }
}
