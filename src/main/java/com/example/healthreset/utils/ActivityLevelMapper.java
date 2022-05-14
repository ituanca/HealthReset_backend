package com.example.healthreset.utils;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.PrimaryFood;
import com.example.healthreset.model.dto.ActivityLevelDTO;
import com.example.healthreset.model.dto.PrimaryFoodDTO;

public class ActivityLevelMapper {

    public ActivityLevel convertDTOtoActivityLevel(ActivityLevelDTO activityLevelDTO) {
        return ActivityLevel.builder()
                .activityLevel(activityLevelDTO.getActivityLevel())
                .build();
    }

    public ActivityLevelDTO convertActivityLevelToDTO(ActivityLevel activityLevel) {
        return ActivityLevelDTO.builder()
                .activityLevel(activityLevel.getActivityLevel())
                .build();
    }

}
