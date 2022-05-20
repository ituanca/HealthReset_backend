package com.example.healthreset.repository;

import com.example.healthreset.model.Specialist;
import com.example.healthreset.model.StatusRoutine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRoutineRepository extends JpaRepository<StatusRoutine, Integer> {

    Optional<StatusRoutine> findByStatusRoutine(String statusRoutine);

}
