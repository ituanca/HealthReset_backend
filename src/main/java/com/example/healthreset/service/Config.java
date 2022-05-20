package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.StatusRoutine;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.repository.ActivityLevelRepository;
import com.example.healthreset.repository.MealOfTheDayRepository;
import com.example.healthreset.repository.StatusRoutineRepository;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

//    @Bean
//    CommandLineRunner commandLineRunner(ActivityLevelRepository repository){
//        return args -> {
//            ActivityLevel activityLevel1 = new ActivityLevel("Sedentary");
//            ActivityLevel activityLevel2 = new ActivityLevel("Somewhat active");
//            ActivityLevel activityLevel3 = new ActivityLevel("Active");
//            ActivityLevel activityLevel4 = new ActivityLevel("Very active");
//            repository.saveAll(List.of(activityLevel1, activityLevel2, activityLevel3, activityLevel4));
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(TypeOfExerciseRepository repository){
//        return args -> {
//            TypeOfExercise typeOfExercise1 = new TypeOfExercise("Cardio");
//            TypeOfExercise typeOfExercise2 = new TypeOfExercise("Strength");
//            TypeOfExercise typeOfExercise3 = new TypeOfExercise("Stretching");
//            repository.saveAll(List.of(typeOfExercise1, typeOfExercise2, typeOfExercise3));
//        };
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(MealOfTheDayRepository repository){
//        return args -> {
//            MealOfTheDay m1 = new MealOfTheDay("Breakfast");
//            MealOfTheDay m2 = new MealOfTheDay("Morning snack");
//            MealOfTheDay m3 = new MealOfTheDay("Lunch");
//            MealOfTheDay m4 = new MealOfTheDay("Afternoon snack");
//            MealOfTheDay m5 = new MealOfTheDay("Dinner");
//            MealOfTheDay m6 = new MealOfTheDay("Evening snack");
//            repository.saveAll(List.of(m1, m2, m3, m4, m5, m6));
//        };
//    }

//        @Bean
//    CommandLineRunner commandLineRunner(StatusRoutineRepository repository){
//        return args -> {
//            StatusRoutine m1 = new StatusRoutine("APPROVED");
//            StatusRoutine m2 = new StatusRoutine("NOT APPROVED");
//            StatusRoutine m3 = new StatusRoutine("DISAPPROVED");
//            repository.save(m3);
//        };
//    }

}
