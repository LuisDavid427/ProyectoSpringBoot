package com.sena.crudbasic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.Column;


@Entity(name="Theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private int id_theme;
    @Column(name = "theme", length = 20)
    private String theme;

    @OneToMany(mappedBy = "Theme")
	private List<Pavilion> pavilions;
		
}