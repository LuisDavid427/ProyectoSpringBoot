package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "fair")
public class Fair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fair")
    private int idFair;

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "fair")
    private List<Pavilion> pavilions;


    public Fair() {
    }   
    public Fair(int idFair, String name, String description, List<Pavilion> pavilions ) {
        this.idFair = idFair;
        this.name = name;
        this.description = description;
        this.pavilions = pavilions;
    }
    public int getIdFair() {
        return idFair;
    }

    public void setIdFair(int idFair) {
        this.idFair = idFair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pavilion> getPavilions() {
        return pavilions;
    }

    public void setPavilions(List<Pavilion> pavilions) {
        this.pavilions = pavilions;
    }
}