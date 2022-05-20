package com.example.healthreset.repository;

import com.example.healthreset.model.PrimaryFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrimaryFoodRepository extends JpaRepository<PrimaryFood,Integer> {

    Optional<PrimaryFood> findByName(String name);

}
