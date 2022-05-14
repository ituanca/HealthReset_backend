package com.example.healthreset.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fitnessProgram")
public class FitnessProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @OneToMany(mappedBy = "fitnessProgram")
    List<PhysicalExercise> listOfExercises;

    @OneToOne
    @JoinColumn(name = "idRoutine")
    Routine routine;

}
