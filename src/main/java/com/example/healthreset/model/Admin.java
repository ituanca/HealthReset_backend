package com.example.healthreset.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Admin extends User{

    @OneToMany(mappedBy = "admin")
    List<Ticket> tickets;

    @OneToMany(mappedBy = "admin")
    List<Routine> routines;

}
