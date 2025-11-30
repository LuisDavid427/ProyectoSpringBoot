
package com.sena.crudbasic.dto;

public class CompanyDto {

    private int idCompany;
    private String companyName;
    private String description;

    // Constructores, Getters y Setters
    public CompanyDto() {}

    public CompanyDto(int idCompany, String companyName, String description) {
        this.idCompany = idCompany;
        this.companyName = companyName;
        this.description = description;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}