package com.example.healthreset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoutineExercise extends Exercise {

    @ManyToMany(mappedBy="listOfPhysicalExercises")
    List<Routine> listOfRoutines;

}
