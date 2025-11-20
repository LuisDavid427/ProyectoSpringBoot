package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "demonstration")
public class Demonstration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demonstration")
    private int idDemonstration;

    @Column(name = "demonstration_name", length = 80)
    private String demonstrationName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}