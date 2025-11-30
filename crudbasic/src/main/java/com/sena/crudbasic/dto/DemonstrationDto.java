package com.sena.crudbasic.dto;

public class DemonstrationDto {

    private int idDemonstration;
    private String demonstrationName;
    private String description;

    public DemonstrationDto() {}

    public DemonstrationDto(int idDemonstration, String demonstrationName, String description) {
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