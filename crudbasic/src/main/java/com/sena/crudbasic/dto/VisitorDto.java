package com.sena.crudbasic.dto;

public class VisitorDto {

    private int idVisitor;
    private int idPerson;    // FK a Person (@OneToOne)
    private int idVisitorType; // FK a VisitorType (@ManyToOne)

    // Constructores, Getters y Setters
    
    public VisitorDto() {}

    public VisitorDto(int idVisitor, int idPerson, int idVisitorType) {
        this.idVisitor = idVisitor;
        this.idPerson = idPerson;
        this.idVisitorType = idVisitorType;
    }

    public int getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(int idVisitor) {
        this.idVisitor = idVisitor;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getIdVisitorType() {
        return idVisitorType;
    }

    public void setIdVisitorType(int idVisitorType) {
        this.idVisitorType = idVisitorType;
    }
}