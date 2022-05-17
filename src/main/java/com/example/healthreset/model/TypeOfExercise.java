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
@Table(name = "typeOfExercise")
public class TypeOfExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String typeOfExercise;

    @OneToMany(mappedBy = "typeOfExercise")
    List<PhysicalExercise> exercises;

    public TypeOfExercise(String typeOfExercise) {
        this.typeOfExercise=typeOfExercise;
    }

}
