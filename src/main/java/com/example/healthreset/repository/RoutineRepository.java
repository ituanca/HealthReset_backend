package com.example.healthreset.repository;

import com.example.healthreset.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine,Integer> {
}
