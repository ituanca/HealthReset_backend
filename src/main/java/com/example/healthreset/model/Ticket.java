package com.example.healthreset.model;

import com.example.healthreset.model.enumClasses.StatusTicket;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String text;

    @Enumerated(EnumType.STRING)
    private StatusTicket statusTicket;

    @ManyToOne
    @JoinColumn(name = "idRegularUser")
    private RegularUser regularUser;

    @ManyToOne
    @JoinColumn(name = "idAdmin")
    private Admin admin;

}
