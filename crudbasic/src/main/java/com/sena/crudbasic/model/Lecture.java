package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lecture")
    private int idLecture;

    @Column(name = "lecture_name", length = 80)
    private String lectureName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}