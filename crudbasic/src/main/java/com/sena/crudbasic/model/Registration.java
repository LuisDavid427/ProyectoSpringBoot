package com.sena.crudbasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private int idRegistration;

    @ManyToOne
    @JoinColumn(name = "id_fair")
    private Fair fair;

    @ManyToOne
    @JoinColumn(name = "id_stand")
    private Stand stand;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "id_lecture")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "id_demonstration")
    private Demonstration demonstration;

    @ManyToOne
    @JoinColumn(name = "id_speaker")
    private Speaker speaker;

    @ManyToOne
    @JoinColumn(name = "id_visitor")
    private Visitor visitor;
}