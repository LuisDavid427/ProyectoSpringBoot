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

@Entity(name = "stand")
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stand")
    private int idStand;

    @Column(name = "stand_name", length = 80)
    private String standName;

    @ManyToOne
    @JoinColumn(name = "id_pavilion")
    private Pavilion pavilion;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(mappedBy = "stand")
    private List<Product> products;
}