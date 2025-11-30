package com.sena.crudbasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity(name = "responsible")
public class Responsible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_responsible")
    private int idResponsible;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public Responsible() {
    }

    public Responsible(int idResponsible, Product product, Person person) {
        this.idResponsible = idResponsible;
        this.product = product;
        this.person = person;
    }

    public int getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(int idResponsible) {
        this.idResponsible = idResponsible;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}