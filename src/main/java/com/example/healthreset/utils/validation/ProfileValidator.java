package com.example.healthreset.utils.validation;

import com.example.healthreset.model.Profile;

import java.time.LocalDate;

public class ProfileValidator{

    public String validate(Profile profile) {
        if(profile.getWeight() < 0){
            return "invalid_weight";
        }else if(profile.getHeight() < 0){
            return "invalid_height";
        }else if(profile.getBirthDate().isAfter(LocalDate.now())){
            return "invalid_birthdate";
        }else if(profile.getActivityLevel()==null) {
            return "invalid_activityLevel";
        }else if(profile.getWeightGoal() < 0){
            return "invalid_weightGoal";
        }else if(profile.getNrOfStepsGoal() < 0){
            return "invalid_nrOfStepsGoal";
        }
        return "ok";
    }

}
