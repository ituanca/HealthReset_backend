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
public class RegularUser extends User{

    @Column(name="name")
    String name;

    @OneToOne(mappedBy = "regularUser")
    private Profile profile;

    @OneToMany(mappedBy = "regularUser")
    List<Ticket> tickets;

    @OneToMany(mappedBy = "regularUser")
    List<TrackedActivity> trackedActivity;

    @OneToMany(mappedBy = "regularUser")
    private List<CustomizedFood> listOfCustomizedFood;

}
