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

    public TrackedExercise(String name,
                           Integer caloriesBurnedPerMinute,
                           TypeOfExercise typeOfExercise,
                           Integer timeOfExecution) {
        super(name, caloriesBurnedPerMinute, typeOfExercise);
        this.timeOfExecution = timeOfExecution;
    }
}
