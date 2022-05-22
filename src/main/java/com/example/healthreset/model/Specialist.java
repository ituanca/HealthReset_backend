package com.example.healthreset.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Specialist extends User{

    @Column(name="name")
    String name;

    @OneToMany(mappedBy = "specialist")
    private List<Routine> routines;

    public Specialist(String email, String username, String password, String name) {
        super(email, username, password);
        this.name = name;
    }

}
