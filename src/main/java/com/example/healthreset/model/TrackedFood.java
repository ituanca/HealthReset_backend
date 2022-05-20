package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TrackedFood extends Food{

    @Column
    String mealOfTheDay;

    @Column
    Double eatenQuantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

    @Override
    public int computeNumberOfCalories() {
        return getCalories();
    }

}
