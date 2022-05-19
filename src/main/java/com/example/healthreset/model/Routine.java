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
    @JoinColumn(name = "idActivityLevel", insertable = false, updatable = false)
    private ActivityLevel activityLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="routine_physicalExercise",
            joinColumns = @JoinColumn(name="idRoutine"),
            inverseJoinColumns = @JoinColumn(name="idPhysicalExercise"))
    private List<PhysicalExercise> listOfPhysicalExercises;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="routine_routineFood",
            joinColumns = @JoinColumn(name="idRoutine"),
            inverseJoinColumns = @JoinColumn(name="idRoutineFood"))
    private List<RoutineFood> listOfFood;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "idActivityLevel")
    private StatusRoutine statusRoutine;

    @ManyToOne
    @JoinColumn(name = "idSpecialist")
    private Specialist specialist;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

}
