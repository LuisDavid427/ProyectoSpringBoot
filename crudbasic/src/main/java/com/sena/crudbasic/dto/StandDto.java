package com.sena.crudbasic.dto;

public class StandDto {

    private int idStand;
    private String standName;
    private int idPavilion; // FK a Pavilion
    private int idCompany;  // FK a Company

    // Constructores, Getters y Setters
    
    public StandDto() {}

    public StandDto(int idStand, String standName, int idPavilion, int idCompany) {
        this.idStand = idStand;
        this.standName = standName;
        this.idPavilion = idPavilion;
        this.idCompany = idCompany;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public String getStandName() {
        return standName;
    }

    public void setStandName(String standName) {
        this.standName = standName;
    }

    public int getIdPavilion() {
        return idPavilion;
    }

    public void setIdPavilion(int idPavilion) {
        this.idPavilion = idPavilion;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }
}