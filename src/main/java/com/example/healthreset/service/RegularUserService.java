package com.example.healthreset.service;

import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.dto.ProfileDTO;
import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.repository.RegularUserRepository;
import com.example.healthreset.utils.ProfileMapper;
import com.example.healthreset.utils.UsersMapper;
import com.example.healthreset.utils.validation.EmailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Slf4j
@Service
public class RegularUserService {

    RegularUserRepository regularUserRepository;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository) {
        this.regularUserRepository = regularUserRepository;
    }

    /**
     * Checks if the email and the username do not exist yet in the database and if the email is valid
     * @param email the email that I want to validate and to check if it exists already in the database or not
     * @param username the username that I want to validate and to check if it exists already in the database or not
     * @return a string representing a message showing the state of this verification
     */
    public String checkIfValid(String email, String username){
        if(regularUserRepository.findByEmail(email).isPresent() ){
            log.warn(" Email " + email + " already exists!");
            return "email_exists";
        }
        if(regularUserRepository.findByUsername(username).isPresent() ){
            log.warn(" Username " + username + " already exists!");
            return  "username_exists";
        }
        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(email)){
            log.warn(" Email " + email + " is not a valid mail!");
            return "invalid_email";
        }
        log.info(" Introduced credentials are valid.");
        return "ok";
    }

    /**
     * Checks the introduced credentials and if they are correct, the regular user will be allowed to enter his account
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return a string which shows if the credentials are correct or not, case which happen when either the username
     * does not exist or the password introduced does not match the password associated to the entered username
     */
    public String login(String username, String password){
        RegularUser regularUser = regularUserRepository.findByUsername(username).orElse(null);
        if (regularUser==null) {
            log.warn(" Username " + username + " does not exist!");
            return "username_error";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.matches(password, regularUser.getPassword())){
            log.warn(" Password is incorrect!");
            return "password_error";
        }
        log.info(" Credentials are valid, regularUser successfully logged in!");
        return "ok";
    }

    /**
     * Gets the profile associated to the specified user
     * @param username the username of the regular user associated to the profile being sought
     * @return a ProfileDTO object in case the profile was found or null otherwise
     */
    public ProfileDTO findProfileByRegularUser(String username){
        RegularUser regularUser = regularUserRepository.findByUsername(username).orElse(null);
        if(regularUser!=null){
            if(regularUser.getProfile() != null){
                log.info(" Profile associated to regularUser " + username + " was found!");
                ProfileMapper profileMapper = new ProfileMapper();
                return profileMapper.convertProfileToDTO(regularUser.getProfile());
            }
        }
        log.warn(" Profile associated to regularUser " + username + " not found!");
        return null;
    }

}
