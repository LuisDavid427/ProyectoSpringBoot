package com.sena.crudbasic.dto;

public class PavilionDto {

    private int idPavilion;
    private String name;
    private int idTheme; // FK a Theme
    private int idFair;  // FK a Fair

    // Constructores, Getters y Setters
    
    public PavilionDto() {}

    public PavilionDto(int idPavilion, String name, int idTheme, int idFair) {
        this.idPavilion = idPavilion;
        this.name = name;
        this.idTheme = idTheme;
        this.idFair = idFair;
    }

    public int getIdPavilion() {
        return idPavilion;
    }

    public void setIdPavilion(int idPavilion) {
        this.idPavilion = idPavilion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getIdFair() {
        return idFair;
    }

    public void setIdFair(int idFair) {
        this.idFair = idFair;
    }
}