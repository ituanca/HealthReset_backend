package com.example.healthreset.controller;

import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.service.RegularUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/regularUser")
public class RegularUserController {

    private final RegularUserService regularUserService;

    @Autowired
    public RegularUserController(RegularUserService regularUserService) {
        this.regularUserService = regularUserService;
    }

    @GetMapping("/checkIfValid")
    public String checkIfValid(@Param("email") String email, @Param("username") String username) {
        log.info(" email entered: " + email);
        log.info(" username entered: " + username);
        return regularUserService.checkIfValid(email, username);
    } // used

    @GetMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password){
        log.info(" username sent from frontend: " + username);
        return regularUserService.login(username, password);
    } // used

}
