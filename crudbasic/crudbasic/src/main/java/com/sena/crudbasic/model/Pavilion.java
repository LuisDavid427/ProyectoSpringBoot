package com.sena.crudbasic.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.Column;

@Entity(name="Pavilion")
public class Pavilion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pavilion")
    private int id_pavilion;
    @Column(name = "name", length = 60)
    private String name;

	@ManyToOne
	@JoinColumn(name="id_theme")//name="nombre llave primaria"
	private Theme theme;
	@JoinColumn(name="id_feria")//name="nombre llave primaria"
	private Feria feria;



}
