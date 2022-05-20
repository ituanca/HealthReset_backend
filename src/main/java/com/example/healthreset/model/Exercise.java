package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "physicalExercise")
public abstract class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;

    @Column
    Integer caloriesBurnedPerMinute;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idTypeOfExercise")
    TypeOfExercise typeOfExercise;

}
