package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrackedExercise extends PhysicalExercise{

    @Column
    Integer timeOfExecution;

    @ManyToOne
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

}
