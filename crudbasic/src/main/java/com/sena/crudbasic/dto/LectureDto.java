package com.sena.crudbasic.dto;

public class LectureDto {

    private int idLecture;
    private String name;
    private String description;

    // Constructores, Getters y Setters
    
    public LectureDto() {}

    public LectureDto(int idLecture, String name, String description) {
        this.idLecture = idLecture;
        this.name = name;
        this.description = description;
    }

    public int getIdLecture() {
        return idLecture;
    }

    public void setIdLecture(int idLecture) {
        this.idLecture = idLecture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}