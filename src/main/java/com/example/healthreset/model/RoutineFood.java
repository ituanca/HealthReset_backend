package com.example.healthreset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RoutineFood extends Food{

    @Column
    String mealOfTheDay;

    @ManyToMany(mappedBy="listOfFood")
    List<Routine> listOfRoutines;

    @Override
    public int computeNumberOfCalories() {
        return getCalories();
    }
}
