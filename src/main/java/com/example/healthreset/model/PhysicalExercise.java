package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "physicalExercise")
public class PhysicalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;

    @Column
    Integer caloriesBurnedPerMinute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTypeOfExercise")
    TypeOfExercise typeOfExercise;

    @ManyToMany(mappedBy="listOfPhysicalExercises")
    List<Routine> listOfRoutines;

    @ManyToOne
    @JoinColumn(name = "idFitnessProgram")
    FitnessProgram fitnessProgram;

}
