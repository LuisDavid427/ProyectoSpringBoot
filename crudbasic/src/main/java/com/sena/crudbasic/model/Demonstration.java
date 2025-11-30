package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "demonstration")
public class Demonstration {

    public Demonstration() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demonstration")
    private int idDemonstration;

    @Column(name = "demonstration_name", length = 80)
    private String demonstrationName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Demonstration(int idDemonstration, String demonstrationName, String description) {
        this.idDemonstration = idDemonstration;
        this.demonstrationName = demonstrationName;
        this.description = description;
    }

    public int getIdDemonstration() {
        return idDemonstration;
    }

    public void setIdDemonstration(int idDemonstration) {
        this.idDemonstration = idDemonstration;
    }

    public String getDemonstrationName() {
        return demonstrationName;
    }

    public void setDemonstrationName(String demonstrationName) {
        this.demonstrationName = demonstrationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}