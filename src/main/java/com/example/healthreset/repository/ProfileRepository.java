package com.example.healthreset.repository;

import com.example.healthreset.model.Admin;
import com.example.healthreset.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {
}
