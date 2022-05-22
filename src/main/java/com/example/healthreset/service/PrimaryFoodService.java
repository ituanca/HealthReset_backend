package com.example.healthreset.service;

import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.dto.PrimaryFoodDTO;
import com.example.healthreset.repository.PrimaryFoodRepository;
import com.example.healthreset.utils.PrimaryFoodMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PrimaryFoodService {

    @Autowired
    PrimaryFoodRepository primaryFoodRepository;

    /**
     * Checks if the entered data is valid and if this is true the food item is inserted into the database
     * @param foodDTO the foodDTO object received form the frontend
     * @return a string which communicates if the data is valid, in which case the food item is inserted into
     * the database, or if the data is invalid and which one of the fields was improperly filled
     */
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

    /**
     * Gets all the primary food items from the database
     * @return a list of PrimaryFoodDTO that is sent to frontend
     */
    public List<PrimaryFoodDTO> findAll(){

        List<PrimaryFood> listOfPrimaryFood = primaryFoodRepository.findAll();
        List<PrimaryFoodDTO> listOfPrimaryFoodDTO = new ArrayList<>();
        PrimaryFoodMapper primaryFoodMapper = new PrimaryFoodMapper();
        for(PrimaryFood t : listOfPrimaryFood){
            listOfPrimaryFoodDTO.add(primaryFoodMapper.convertPrimaryFoodToDTO(t));
        }
        log.info(" Food " + listOfPrimaryFoodDTO + " successfully fetched from database!");
        return listOfPrimaryFoodDTO;

    }

}
