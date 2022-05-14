package com.example.healthreset.model;

import com.example.healthreset.model.enumClasses.MealOfTheDay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trackedFood")
public class TrackedFood extends Food{

    //@Convert(converter = MealOfTheDayJpaConverter.class)
    @Enumerated(EnumType.STRING)
    MealOfTheDay mealOfTheDay;

    @Override
    public int computeNumberOfCalories() {
        return 0;
    }
}
