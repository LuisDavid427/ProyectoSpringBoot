package com.sena.crudbasic.dto;

import java.util.List;

import com.sena.crudbasic.model.Pavilion;

public class FairDto {

    private int idFair;
    private String name;
    private String description;
    private List<Pavilion> pavilions;

    public int getIdFair() {
        return idFair;
    }
    
    public FairDto() {

    }
    public FairDto(int idFair, String name, String description) {
        this.idFair = idFair;
        this.name = name;
        this.description = description;
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

}