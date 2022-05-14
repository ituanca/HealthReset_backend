package com.example.healthreset.controller;

import com.example.healthreset.model.dto.ActivityLevelDTO;
import com.example.healthreset.service.ActivityLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="/activityLevel")
public class ActivityLevelController {

    private final ActivityLevelService activityLevelService;

    public ActivityLevelController(ActivityLevelService activityLevelService) {
        this.activityLevelService = activityLevelService;
    }

    @GetMapping("/index")
    public List<ActivityLevelDTO> findAll(){
        return activityLevelService.findAll();
    }

}
