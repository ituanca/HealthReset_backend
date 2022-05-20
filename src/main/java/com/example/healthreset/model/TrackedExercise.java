package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrackedExercise extends Exercise {

    @Column
    Integer timeOfExecution;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

}
