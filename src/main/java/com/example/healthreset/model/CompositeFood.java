package com.example.healthreset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CompositeFood extends Food {

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="compositeFood_food",
            joinColumns = @JoinColumn(name="idCompositeFood"),
            inverseJoinColumns = @JoinColumn(name="idFood"))
    private List<Food> listOfIngredients;

    @Override
    public int computeNumberOfCalories() {
        int nrOfCalories = 0;
        for(Food f: listOfIngredients){
            nrOfCalories += f.getCalories();
        }
        return nrOfCalories;
    }

}
