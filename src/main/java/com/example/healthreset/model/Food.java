package com.example.healthreset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "food")
public abstract class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String name;

    @Column
    int calories;

    @Column
    int protein;

    @Column
    int fat;

    @Column
    int sodium;

    @Column
    int quantity;

    @ManyToMany(mappedBy = "listOfIngredients")
    List<CompositeFood> listOfCompositeFood;

    public abstract int computeNumberOfCalories();

}
