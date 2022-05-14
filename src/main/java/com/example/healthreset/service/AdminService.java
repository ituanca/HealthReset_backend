package com.example.healthreset.service;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.dto.UserDTO;
import com.example.healthreset.repository.AdminRepository;
import com.example.healthreset.utils.UsersMapper;
import com.example.healthreset.utils.validation.EmailValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Slf4j
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll(){
        List<Admin> list = adminRepository.findAll();
        if(list.isEmpty()){
            log.warn("AdminService:findAll " + " There were not found any administrators in the database!");
        }else{
            log.info("AdminService:findAll " + " All existent admins were successfully fetched from database!");
        }
        return list;
    }

    public Optional<Admin> findById(Integer id){
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isEmpty()){
            log.warn("Admin:Service:findById " + " Admin with id " + id + " was not found!");
        }else{
            log.info("AdminService:findById " + " Admin with id " + id + " was found!");
        }
        return admin;
    }

    public Optional<Admin> findByUsername(String name){
        Optional<Admin> admin = adminRepository.findByUsername(name);
        if(admin.isEmpty()){
            log.warn("Admin:Service:findByUsername " + " Admin with username " + name + " was not found!");
        }else{
            log.info("AdminService:findByUsername " + " Admin with username " + name + " was found!");
        }
        return adminRepository.findByUsername(name);
    }

    public String signUp(UserDTO adminDTO){
        if(adminRepository.findByEmail(adminDTO.getEmail()).isPresent() ){
            log.warn("AdminService:signUp " + " Email " + adminDTO.getEmail() + " already exists!");
            return "email_exists";
        }
        if(adminRepository.findByUsername(adminDTO.getUsername()).isPresent() ){
            log.warn("AdminService:signUp " + " Username " + adminDTO.getUsername() + " already exists!");
            return "username_exists";
        }

        UsersMapper adminMapper = new UsersMapper();
        Admin admin = adminMapper.convertDTOtoAdmin(adminDTO);

        EmailValidator emailValidator = new EmailValidator();
        if(!emailValidator.validate(adminDTO.getEmail())){
            log.warn(" Email " + adminDTO.getEmail() + " is not a valid mail!");
            return "invalid_email";
        }
        log.info("Introduced credentials are valid.");
        adminRepository.save(admin);
        return "ok";
    }

    public String login(String username, String password){
        Admin admin = adminRepository.findByUsername(username).orElse(null);
        if (admin==null) {
            log.warn(" Username " + username + " does not exist!");
            return "username_error";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!bCryptPasswordEncoder.matches(password, admin.getPassword())){
            log.warn(" Password is incorrect!");
            return "password_error";
        }
        log.info(" Credentials are valid, admin successfully logged in!");
        return "ok";
    }

}
