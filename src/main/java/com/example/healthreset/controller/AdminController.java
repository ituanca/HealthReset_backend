package com.example.healthreset.controller;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path="/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/index")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> findById(@PathVariable Integer id){
        log.info("AdminController:findById " + " id entered: " + id);
        return adminService.findById(id);
    }

    @PostMapping(path = "/signUp", consumes = {"application/json"})
    public String signUp(@RequestBody UserDTO userDTO) {
        log.info("AdminController:signUp " + " email entered: " + userDTO.getEmail());
        log.info("AdminController:signUp " + " username entered: " + userDTO.getUsername());
        return adminService.signUp(userDTO);
    } // used

    @GetMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password){
        log.info("AdminController:login " + " username sent from frontend: " + username);
        return adminService.login(username, password);
    } // used
}
