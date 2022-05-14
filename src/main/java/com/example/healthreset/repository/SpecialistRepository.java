package com.example.healthreset.repository;

import com.example.healthreset.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialistRepository extends JpaRepository<Specialist,Integer> {

    Optional<Specialist> findByUsername(String username);

    Optional<Specialist> findByEmail(String email);

}
