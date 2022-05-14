package com.example.healthreset.service;

import com.example.healthreset.model.ActivityLevel;
import com.example.healthreset.repository.ActivityLevelRepository;
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

}
