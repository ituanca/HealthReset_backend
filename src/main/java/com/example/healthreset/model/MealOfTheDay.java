package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "mealOfTheDay")
public class MealOfTheDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // the field is auto-generated and it will not be provided by the user
    private Integer id;

    @Column
    private String mealOfTheDay;

    @OneToMany(mappedBy = "mealOfTheDay")
    private List<TrackedFood> listOfTrackedFood;

    public MealOfTheDay(String mealOfTheDay) {
        this.mealOfTheDay = mealOfTheDay;
    }
}
