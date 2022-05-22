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

    /**
     * Calls a method to validate the data and if the result is true the profile is inserted into the database
     * @param profileDTO the profileDTO object received form the frontend
     * @return a string which communicates if the data is valid, in which case the profile is created,
     * or if the data is invalid and which one of the fields was improperly filled
     */
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

    /**
     * Calls a method which validates the data sent from the frontend and if the result is true, the profile is updated
     * @param profileDTO the profileDTO object received form the frontend
     * @return a string which communicates if the data is valid, in which case the profile is updated in the database,
     * or if the data is invalid and which one of the fields was improperly filled
     */
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
