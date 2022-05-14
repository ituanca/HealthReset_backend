package com.example.healthreset.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrimaryFoodDTO {

    String name;
    String calories;
    String protein;
    String fat;
    String sodium;
    String quantity;

}
