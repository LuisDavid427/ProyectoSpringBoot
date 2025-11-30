package com.sena.crudbasic.dto;

public class PersonDto {

    private int idPerson;
    private String name;
    private String dni;
    private String phone;
    
    // NOTA: No incluimos las referencias a Speaker ni Visitor, solo sus IDs si fueran claves foráneas.
    // Dado que Speaker y Visitor tienen la FK a Person, no es necesario aquí.

    // Constructores, Getters y Setters
    
    public PersonDto() {}

    public PersonDto(int idPerson, String name, String dni, String phone) {
        this.idPerson = idPerson;
        this.name = name;
        this.dni = dni;
        this.phone = phone;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}