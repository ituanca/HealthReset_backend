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

@Slf4j
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    /**
     * Gets all the administrators from the database
     * @return a list of all the administrators
     */
    public List<Admin> findAll(){
        List<Admin> list = adminRepository.findAll();
        if(list.isEmpty()){
            log.warn(" There were not found any administrators in the database!");
        }else{
            log.info(" All existent admins were successfully fetched from database!");
        }
        return list;
    }

    /**
     * Gets the administrator with the specified id
     * @param id the id I want the administrator that I am looking for to have
     * @return either an admin object, or null in case the admin with the specified id does not exist in the database
     */
    public Optional<Admin> findById(Integer id){
        Optional<Admin> admin = adminRepository.findById(id);
        if(admin.isEmpty()){
            log.warn("Admin:Service:findById " + " Admin with id " + id + " was not found!");
        }else{
            log.info("AdminService:findById " + " Admin with id " + id + " was found!");
        }
        return admin;
    }

    /**
     * Gets the administrator with the specified username
     * @param name the name I want the administrator that I am looking for to have
     * @return either an admin object, or null in case the admin with the specified name does not exist in the database
     */
    public Optional<Admin> findByUsername(String name){
        Optional<Admin> admin = adminRepository.findByUsername(name);
        if(admin.isEmpty()){
            log.warn(" Admin with username " + name + " was not found!");
        }else{
            log.info(" Admin with username " + name + " was found!");
        }
        return adminRepository.findByUsername(name);
    }

    /**
     * Inserts the admin into the database after making the necessary validations of the entered data
     * @param adminDTO the userDTO received from the frontend
     * @return a string representing a message which communicates the type of the error if the entered data
     * is not valid or the fact that the data is valid and the admin was inserted into the database
     */
    public String signUp(UserDTO adminDTO){
        if(adminRepository.findByEmail(adminDTO.getEmail()).isPresent() ){
            log.warn(" Email " + adminDTO.getEmail() + " already exists!");
            return "email_exists";
        }
        if(adminRepository.findByUsername(adminDTO.getUsername()).isPresent() ){
            log.warn(" Username " + adminDTO.getUsername() + " already exists!");
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

    /**
     * Checks the introduced credentials and if they are correct, the admin will be allowed to enter his account
     * @param username the username entered by the user
     * @param password the password entered by the user
     * @return a string which shows if the credentials are correct or not, case which happen when either the username
     * does not exist or the password introduced does not match the password associated to the entered username
     */
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
