package com.sena.crudbasic.dto;

public class ResponsibleDto {

    private int idResponsible;
    private int idProduct; // FK a Product
    private int idPerson;  // FK a Person

    // Constructores, Getters y Setters
    
    public ResponsibleDto() {}

    public ResponsibleDto(int idResponsible, int idProduct, int idPerson) {
        this.idResponsible = idResponsible;
        this.idProduct = idProduct;
        this.idPerson = idPerson;
    }

    public int getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(int idResponsible) {
        this.idResponsible = idResponsible;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}