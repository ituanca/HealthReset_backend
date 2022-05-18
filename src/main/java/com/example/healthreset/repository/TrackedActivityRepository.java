package com.example.healthreset.repository;

import com.example.healthreset.model.TrackedActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackedActivityRepository extends JpaRepository<TrackedActivity, Integer> {
}
