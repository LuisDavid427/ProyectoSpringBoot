package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "stand")
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stand")
    private int idStand;

    @Column(name = "stand_name", length = 80)
    private String standName;

    @ManyToOne
    @JoinColumn(name = "id_pavilion")
    private Pavilion pavilion;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(mappedBy = "stand")
    private List<Product> products;

    public Stand() {
    }

    public Stand(int idStand, String standName, Pavilion pavilion, Company company, List<Product> products) {
        this.idStand = idStand;
        this.standName = standName;
        this.pavilion = pavilion;
        this.company = company;
        this.products = products;
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

    public Pavilion getPavilion() {
        return pavilion;
    }

    public void setPavilion(Pavilion pavilion) {
        this.pavilion = pavilion;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}