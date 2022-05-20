package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "idActivityLevelRoutine")
    ActivityLevel activityLevelRoutine;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="routine_routineExercise",
            joinColumns = @JoinColumn(name="idRoutine"),
            inverseJoinColumns = @JoinColumn(name="idRoutineExercise"))
    private List<RoutineExercise> listOfPhysicalExercises;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="routine_routineFood",
            joinColumns = @JoinColumn(name="idRoutine"),
            inverseJoinColumns = @JoinColumn(name="idRoutineFood"))
    private List<RoutineFood> listOfFood;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "idStatusRoutine")
    private StatusRoutine statusRoutine;

    @ManyToOne
    @JoinColumn(name = "idSpecialist")
    private Specialist specialist;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

}
