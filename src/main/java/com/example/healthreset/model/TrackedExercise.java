package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrackedExercise extends PhysicalExercise{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTrackedActivity")
    TrackedActivity trackedActivity;

}
