package com.sena.crudbasic.dto;

public class RegistrationDto {

    private int idRegistration;
    private int idFair;
    private int idStand;
    private int idCompany;
    private int idLecture;
    private int idDemonstration;
    private int idSpeaker;
    private int idVisitor;

    // Constructores, Getters y Setters
    
    public RegistrationDto() {}

    public RegistrationDto(int idRegistration, int idFair, int idStand, int idCompany, int idLecture,
            int idDemonstration, int idSpeaker, int idVisitor) {
        this.idRegistration = idRegistration;
        this.idFair = idFair;
        this.idStand = idStand;
        this.idCompany = idCompany;
        this.idLecture = idLecture;
        this.idDemonstration = idDemonstration;
        this.idSpeaker = idSpeaker;
        this.idVisitor = idVisitor;
    }

    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }

    public int getIdFair() {
        return idFair;
    }

    public void setIdFair(int idFair) {
        this.idFair = idFair;
    }

    public int getIdStand() {
        return idStand;
    }

    public void setIdStand(int idStand) {
        this.idStand = idStand;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public int getIdDemonstration() {
        return idDemonstration;
    }

    public void setIdDemonstration(int idDemonstration) {
        this.idDemonstration = idDemonstration;
    }

    public int getIdSpeaker() {
        return idSpeaker;
    }

    public void setIdSpeaker(int idSpeaker) {
        this.idSpeaker = idSpeaker;
    }

    public int getIdVisitor() {
        return idVisitor;
    }

    public void setIdVisitor(int idVisitor) {
        this.idVisitor = idVisitor;
    }
}