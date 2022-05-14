package com.example.healthreset.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column
    Double weight;

    @Column
    Double height;

    @Column
    LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "idActivityLevel")
    ActivityLevel activityLevel;

    @Column
    Double weightGoal;

    @Column
    Integer nrOfStepsGoal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRegularUser")  // FK
    private RegularUser regularUser;

}
