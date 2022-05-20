package com.example.healthreset.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoutineFoodDTO {

    String name;
    String calories;
    String protein;
    String fat;
    String sodium;
    String quantity;
    String mealOfTheDay;

}