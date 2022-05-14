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
public class ActivityLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  // the field is auto-generated and it will not be provided by the user
    private Integer id;

    @Column // the field is auto-generated and it will not be provided by the user
    private String activityLevel;

    @OneToMany(mappedBy = "activityLevel")
    private List<Routine> routines;

    @OneToMany(mappedBy = "activityLevel")
    private List<Profile> profiles;

    public ActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
}
