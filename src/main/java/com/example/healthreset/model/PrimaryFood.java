package com.example.healthreset.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class PrimaryFood extends Food{
    @Column
    int protein;

    @Column
    int fat;

    @Column
    int sodium;

    @Column
    int quantity;

    @Column
    String mealOfTheDay;

    @Column
    Double eatenQuantity;

    @Override
    public int computeNumberOfCalories() {
        return getCalories();
    }
}
