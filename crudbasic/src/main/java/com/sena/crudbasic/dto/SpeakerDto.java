package com.sena.crudbasic.dto;

public class SpeakerDto {

    private int idSpeaker;
    private int idPerson; // FK a Person

    // Constructores, Getters y Setters
    
    public SpeakerDto() {}

    public SpeakerDto(int idSpeaker, int idPerson) {
        this.idSpeaker = idSpeaker;
        this.idPerson = idPerson;
    }

    public int getIdSpeaker() {
        return idSpeaker;
    }

    public void setIdSpeaker(int idSpeaker) {
        this.idSpeaker = idSpeaker;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
}