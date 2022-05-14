package com.example.healthreset.repository;

import com.example.healthreset.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Optional<Admin> findByUsername(String username);

    Optional<Admin> findByEmail(String email);

}
