package com.example.healthreset.repository;

import com.example.healthreset.model.Profile;
import com.example.healthreset.model.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile,Integer> {

    Optional<Profile> findById(Integer id);

    Optional<Profile> findByRegularUser(RegularUser regularUser);

}
