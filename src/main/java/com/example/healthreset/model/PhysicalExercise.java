package com.example.healthreset.model;

import com.example.healthreset.model.enumClasses.TypeOfExercise;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "physicalExercise")
public class PhysicalExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;

    @Enumerated(EnumType.STRING)
    TypeOfExercise typeOfExercise;

    @ManyToMany(mappedBy="listOfPhysicalExercises")
    List<Routine> listOfRoutines;

    @ManyToOne
    @JoinColumn(name = "idFitnessProgram")
    FitnessProgram fitnessProgram;

}
