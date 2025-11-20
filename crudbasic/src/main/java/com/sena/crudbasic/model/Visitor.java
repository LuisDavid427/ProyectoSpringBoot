package com.sena.crudbasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Column;

@Entity(name = "visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visitor")
    private int idVisitor;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private VisitorType visitorType;
}