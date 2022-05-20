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
@Table(name = "statusRoutine")
public class StatusRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    String statusRoutine;

    @OneToMany(mappedBy = "statusRoutine")
    private List<Routine> routines;

    public StatusRoutine(String statusRoutine) {
        this.statusRoutine = statusRoutine;
    }
}
