package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TrackedFoodDTO {

    String name;
    String calories;
    String protein;
    String fat;
    String sodium;
    String quantity;
    String mealOfTheDay;
    Double eatenQuantity;

}
