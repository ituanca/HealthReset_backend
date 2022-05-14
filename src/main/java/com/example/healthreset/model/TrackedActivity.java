package com.example.healthreset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trackedActivity")
public class TrackedActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idRegularUser")
    private RegularUser regularUser;

    @Column
    private LocalDateTime trackedDay;

    @Column
    private Integer nrOfSteps;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="trackedActivity_physicalExercise",
            joinColumns = @JoinColumn(name="idTrackedActivity"),
            inverseJoinColumns = @JoinColumn(name="idPhysicalExercise"))
    private List<PhysicalExercise> listOfPhysicalExercises;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="trackedActivity_food",
            joinColumns = @JoinColumn(name="idTrackedActivity"),
            inverseJoinColumns = @JoinColumn(name="idTrackedFood"))
    private List<TrackedFood> listOfTrackedFood;

}
