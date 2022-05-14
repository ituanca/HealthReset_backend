package com.example.healthreset.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mealPlan")
public class MealPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="mealPlan_food",
            joinColumns = @JoinColumn(name="idMealPlan"),
            inverseJoinColumns = @JoinColumn(name="idFood"))
    List<Food> listOfFood;

    @OneToOne
    @JoinColumn(name = "idRoutine")
    Routine routine;

}
