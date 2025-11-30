package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person")
    private int idPerson;

    @Column(name = "name", length = 70)
    private String name;

    @Column(name = "dni", length = 12)
    private String dni;

    @Column(name = "phone", length = 13)
    private String phone;

    @OneToOne(mappedBy = "person")
    private Speaker speaker;

    @OneToOne(mappedBy = "person")
    private Visitor visitor;

    public Person() {
    }

    public Person(int idPerson, String name, String dni, String phone, Speaker speaker, Visitor visitor) {
        this.idPerson = idPerson;
        this.name = name;
        this.dni = dni;
        this.phone = phone;
        this.speaker = speaker;
        this.visitor = visitor;
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

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}