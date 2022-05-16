package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.Profile;
import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.dto.ProfileDTO;
import com.example.healthreset.repository.ActivityLevelRepository;
import com.example.healthreset.repository.ProfileRepository;
import com.example.healthreset.repository.RegularUserRepository;
import com.example.healthreset.utils.ProfileMapper;
import com.example.healthreset.utils.UsersMapper;
import com.example.healthreset.utils.validation.ProfileValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ActivityLevelRepository activityLevelRepository;
    private final RegularUserRepository regularUserRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, ActivityLevelRepository activityLevelRepository, RegularUserRepository regularUserRepository) {
        this.profileRepository = profileRepository;
        this.activityLevelRepository = activityLevelRepository;
        this.regularUserRepository = regularUserRepository;
    }

    public String createProfile(ProfileDTO profileDTO) {
        String activityLevelString = profileDTO.getActivityLevel();
        ActivityLevel activityLevel =
                activityLevelRepository.findByActivityLevel(activityLevelString).orElse(null);

        UsersMapper usersMapper = new UsersMapper();
        RegularUser regularUser = usersMapper.convertDTOtoRegularUser(profileDTO.getRegularUser());

        ProfileMapper profileMapper = new ProfileMapper();
        Profile profile = profileMapper.convertDTOtoProfile(profileDTO);

        profile.setActivityLevel(activityLevel);
        profile.setRegularUser(regularUser);

        ProfileValidator profileValidator = new ProfileValidator();
        String result = profileValidator.validate(profile);

        if(result.equals("ok")){
            profileRepository.save(profile);
            log.info(" Profile created!");
        }
        return result;
    }

    public String updateProfile(ProfileDTO profileDTO){
        String activityLevelString = profileDTO.getActivityLevel();
        ActivityLevel activityLevel =
                activityLevelRepository.findByActivityLevel(activityLevelString).orElse(null);

        ProfileMapper profileMapper = new ProfileMapper();
        Profile updatedProfile = profileMapper.convertDTOtoProfile(profileDTO);

        updatedProfile.setActivityLevel(activityLevel);

        ProfileValidator profileValidator = new ProfileValidator();
        String result = profileValidator.validate(updatedProfile);

       if(result.equals("ok")){
           profileRepository.findById(profileDTO.getId())
                   .map(profile -> {
                       profile.setWeight(updatedProfile.getWeight());
                       profile.setHeight(updatedProfile.getHeight());
                       profile.setBirthDate(updatedProfile.getBirthDate());
                       profile.setActivityLevel(updatedProfile.getActivityLevel());
                       profile.setWeightGoal(updatedProfile.getWeightGoal());
                       profile.setNrOfStepsGoal(updatedProfile.getNrOfStepsGoal());
                       return profileRepository.save(profile);
                   })
                   .orElseGet(() -> null);
           log.info(" Profile updated!");
       }
       return result;
    }

}
