package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.dto.ActivityLevelDTO;
import com.example.healthreset.repository.ActivityLevelRepository;
import com.example.healthreset.utils.ActivityLevelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ActivityLevelService {


    private final ActivityLevelRepository activityLevelRepository;

    public ActivityLevelService(ActivityLevelRepository activityLevelRepository) {
        this.activityLevelRepository = activityLevelRepository;
    }

    public List<ActivityLevelDTO> findAll(){
        List<ActivityLevel> activityLevels = activityLevelRepository.findAll();
        List<ActivityLevelDTO> activityLevelDTO = new ArrayList<>();
        ActivityLevelMapper activityLevelMapper = new ActivityLevelMapper();
        for(ActivityLevel a : activityLevels){
            activityLevelDTO.add(activityLevelMapper.convertActivityLevelToDTO(a));
        }
        log.info(" Activity levels " + activityLevelDTO + " successfully fetched from database!");
        return activityLevelDTO;
    }
}
