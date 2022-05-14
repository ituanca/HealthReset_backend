package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.Profile;
import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.dto.ProfileDTO;
import com.example.healthreset.repository.ActivityLevelRepository;
import com.example.healthreset.repository.ProfileRepository;
import com.example.healthreset.utils.ProfileMapper;
import com.example.healthreset.utils.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ActivityLevelRepository activityLevelRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, ActivityLevelRepository activityLevelRepository) {
        this.profileRepository = profileRepository;
        this.activityLevelRepository = activityLevelRepository;
    }

    public String createProfile(ProfileDTO profileDTO) {

        String activityLevelString = profileDTO.getActivityLevel();
        ActivityLevel activityLevel =
                activityLevelRepository.findByActivityLevel(activityLevelString).orElse(null);

        if(activityLevel!=null){
            log.warn(" activityLevel: " + activityLevel.getActivityLevel());
        }

        UsersMapper usersMapper = new UsersMapper();
        RegularUser regularUser = usersMapper.convertDTOtoRegularUser(profileDTO.getRegularUser());

        ProfileMapper profileMapper = new ProfileMapper();
        Profile profile = profileMapper.convertDTOtoProfile(profileDTO);
        profile.setActivityLevel(activityLevel);
        profile.setRegularUser(regularUser);

        if(profile.getWeight() < 0){
            log.warn(" Weight " + profile.getWeight() + " is not a valid weight!");
            return "invalid_weight";
        }else if(profile.getHeight() < 0){
            log.warn(" Height " + profile.getHeight() + " is not a valid height!");
            return "invalid_height";
        }else if(profile.getBirthDate().isAfter(LocalDate.now())){
            log.warn(" Birthdate " + profile.getBirthDate() + " is not a valid birthDate!");
            return "invalid_birthdate";
        }else if(profile.getWeightGoal() < 0){
            log.warn(" Weight goal " + profile.getHeight() + " is not a valid weight goal!");
            return "invalid_weightGoal";
        }else if(profile.getNrOfStepsGoal() < 0){
            log.warn(" Number of steps goal " + profile.getNrOfStepsGoal() + " is not a number of steps goal!");
            return "invalid_nrOfStepsGoal";
        }
        profileRepository.save(profile);
        log.info(" Profile created!");
        return "ok";
    }

}
