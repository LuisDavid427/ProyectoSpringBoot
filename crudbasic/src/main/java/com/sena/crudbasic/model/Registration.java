package com.sena.crudbasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private int idRegistration;

    @ManyToOne
    @JoinColumn(name = "id_fair")
    private Fair fair;

    @ManyToOne
    @JoinColumn(name = "id_stand")
    private Stand stand;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "id_lecture")
    private Lecture lecture;

    @ManyToOne
    @JoinColumn(name = "id_demonstration")
    private Demonstration demonstration;

    @ManyToOne
    @JoinColumn(name = "id_speaker")
    private Speaker speaker;

    @ManyToOne
    @JoinColumn(name = "id_visitor")
    private Visitor visitor;

    public Registration() {
    }

    public Registration(int idRegistration, Fair fair, Stand stand, Company company, Lecture lecture,
            Demonstration demonstration, Speaker speaker, Visitor visitor) {
        this.idRegistration = idRegistration;
        this.fair = fair;
        this.stand = stand;
        this.company = company;
        this.lecture = lecture;
        this.demonstration = demonstration;
        this.speaker = speaker;
        this.visitor = visitor;
    }

    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }

    public Fair getFair() {
        return fair;
    }

    public void setFair(Fair fair) {
        this.fair = fair;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Demonstration getDemonstration() {
        return demonstration;
    }

    public void setDemonstration(Demonstration demonstration) {
        this.demonstration = demonstration;
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