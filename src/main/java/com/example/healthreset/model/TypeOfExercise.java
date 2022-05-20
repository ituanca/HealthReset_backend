package com.example.healthreset.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @OneToMany(mappedBy = "typeOfExercise")
    List<Exercise> exercises;

    public TypeOfExercise(String typeOfExercise) {
        this.typeOfExercise=typeOfExercise;
    }

}
