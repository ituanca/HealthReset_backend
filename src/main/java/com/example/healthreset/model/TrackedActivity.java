package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private LocalDate trackedDay;

    @Column
    private Integer nrOfSteps;

    @OneToMany(mappedBy="trackedActivity")
    private List<TrackedExercise> listOfTrackedExercises;

    @OneToMany(mappedBy="trackedActivity")
    private List<TrackedFood> listOfTrackedFood;

}
