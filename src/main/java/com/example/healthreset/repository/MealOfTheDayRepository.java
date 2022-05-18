package com.example.healthreset.repository;

import com.example.healthreset.model.MealOfTheDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealOfTheDayRepository extends JpaRepository<MealOfTheDay, Integer> {
    Optional<MealOfTheDay> findByMealOfTheDay(String mealOfTheDay);
}
