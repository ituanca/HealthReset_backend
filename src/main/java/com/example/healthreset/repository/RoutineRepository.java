package com.example.healthreset.repository;

import com.example.healthreset.model.Profile;
import com.example.healthreset.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {

    Optional<Routine> findById(Integer id);

    Optional<Routine> findByName(String name);

}
