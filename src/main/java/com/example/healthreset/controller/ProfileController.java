package com.example.healthreset.controller;

import com.example.healthreset.model.dto.ProfileDTO;
import com.example.healthreset.service.ProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@Slf4j
@RestController
@RequestMapping(path="/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping(path = "/create", consumes = {"application/json"})     // post is used when we want to add more resources to our system
    public String createProfile(@RequestBody ProfileDTO profileDTO) throws URISyntaxException {
        log.info(" data entered: " +
                profileDTO.getRegularUser().getUsername() + " " +
                profileDTO.getWeight() + " " +
                profileDTO.getHeight() + " " +
                profileDTO.getBirthdate() + " " +
                profileDTO.getActivityLevel() + " " +
                profileDTO.getWeightGoal() + " " +
                profileDTO.getNrOfStepsGoal());
        return profileService.createProfile(profileDTO);
    }

}
