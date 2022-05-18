package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TrackedFood extends PrimaryFood{

    @ManyToOne
    @JoinColumn(name = "idMealOfTheDay")
    MealOfTheDay mealOfTheDay;

    @Column
    Double trackedQuantity;

    @ManyToOne
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

    @Override
    public int computeNumberOfCalories() {
        return 0;
    }

}
