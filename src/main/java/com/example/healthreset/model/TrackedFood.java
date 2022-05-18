package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrackedFood extends PrimaryFood{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMealOfTheDay")
    MealOfTheDay mealOfTheDay;

    @Column
    Double eatenQuantity;

    @ManyToOne
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

    @Override
    public int computeNumberOfCalories() {
        return 0;
    }

}
