package com.example.healthreset.service;

import com.example.healthreset.model.RegularUser;
import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.repository.RegularUserRepository;
import com.example.healthreset.utils.UsersMapper;
import com.example.healthreset.utils.validation.EmailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Slf4j
@Service
public class RegularUserService {

    RegularUserRepository regularUserRepository;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository) {
        this.regularUserRepository = regularUserRepository;
    }

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

}
