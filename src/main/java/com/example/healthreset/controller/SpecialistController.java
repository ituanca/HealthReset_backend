package com.example.healthreset.controller;

import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.service.SpecialistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/specialist")
public class SpecialistController {

    private final SpecialistService specialistService;

    @Autowired
    public SpecialistController(SpecialistService specialistService) {
        this.specialistService = specialistService;
    }

    @PostMapping(path = "/signUp", consumes = {"application/json"})
    public String signUp(@RequestBody UserDTO userDTO) {
        log.info(" email entered: " + userDTO.getEmail());
        log.info(" username entered: " + userDTO.getUsername());
        return specialistService.signUp(userDTO);
    } // used

    @GetMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password){
        log.info(" username sent from frontend: " + username);
        return specialistService.login(username, password);
    } // used


}
