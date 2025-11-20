package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "pavilion")
public class Pavilion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pavilion")
    private int idPavilion;

    @Column(name = "name", length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "id_fair")
    private Fair fair;

    @OneToMany(mappedBy = "pavilion")
    private List<Stand> stands;
}