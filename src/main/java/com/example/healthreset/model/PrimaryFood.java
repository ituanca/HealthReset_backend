package com.example.healthreset.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
public class PrimaryFood extends Food{

    @Override
    public int computeNumberOfCalories() {
        return getCalories();
    }

}
