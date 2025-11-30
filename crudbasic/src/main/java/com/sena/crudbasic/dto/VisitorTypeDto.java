package com.sena.crudbasic.dto;

public class VisitorTypeDto {

    private int idType;
    private String typeName;

    // Constructores, Getters y Setters
    
    public VisitorTypeDto() {}

    public VisitorTypeDto(int idType, String typeName) {
        this.idType = idType;
        this.typeName = typeName;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}