package com.sena.crudbasic.dto;

public class ProductDto {

    private int idProduct;
    private String name;
    private int idStand; // FK a Stand

    // Constructores, Getters y Setters
    
    public ProductDto() {}

    public ProductDto(int idProduct, String name, int idStand) {
        this.idProduct = idProduct;
        this.name = name;
        this.idStand = idStand;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }
}