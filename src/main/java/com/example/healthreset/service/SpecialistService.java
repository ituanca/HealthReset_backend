package com.example.healthreset.service;

import com.example.healthreset.model.Specialist;
import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.repository.SpecialistRepository;
import com.example.healthreset.utils.UsersMapper;
import com.example.healthreset.utils.validation.EmailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SpecialistService {

    private final SpecialistRepository specialistRepository;

    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository) {
        this.specialistRepository = specialistRepository;
    }

    public String signUp(UserDTO specialistDTO){
        if(specialistRepository.findByEmail(specialistDTO.getEmail()).isPresent() ){
            log.warn(" Email " + specialistDTO.getEmail() + " already exists!");
            return "email_exists";
        }
        if(specialistRepository.findByUsername(specialistDTO.getUsername()).isPresent() ){
            log.warn(" Username " + specialistDTO.getUsername() + " already exists!");
            return "username_exists";
        }

        UsersMapper specialistMapper = new UsersMapper();
        Specialist specialist = specialistMapper.convertDTOtoSpecialist(specialistDTO);

        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(specialistDTO.getEmail())){
            log.warn(" Email " + specialistDTO.getEmail() + " is not a valid mail!");
            return "invalid_email";
        }
        log.info("Introduced credentials are valid.");
        specialistRepository.save(specialist);
        return "ok";
    }

    public String login(String username, String password){
        Specialist specialist = specialistRepository.findByUsername(username).orElse(null);
        if (specialist==null) {
            log.warn(" Username " + username + " does not exist!");
            return "username_error";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.matches(password, specialist.getPassword())){
            log.warn(" Password is incorrect!");
            return "password_error";
        }
        log.info(" Credentials are valid, specialist successfully logged in!");
        return "ok";
    }

}
