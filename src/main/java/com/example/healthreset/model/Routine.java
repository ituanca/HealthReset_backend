package com.example.healthreset.model;

import com.example.healthreset.model.enumClasses.StatusRoutine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routine")
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(mappedBy = "routine")
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "idActivityLevel")
    private ActivityLevel activityLevel;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="routine_physicalExercise",
            joinColumns = @JoinColumn(name="idRoutine"),
            inverseJoinColumns = @JoinColumn(name="idPhysicalExercise"))
    private List<PhysicalExercise> listOfPhysicalExercises;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusRoutine statusRoutine;

    @ManyToOne
    @JoinColumn(name = "idSpecialist")
    private Specialist specialist;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

}
