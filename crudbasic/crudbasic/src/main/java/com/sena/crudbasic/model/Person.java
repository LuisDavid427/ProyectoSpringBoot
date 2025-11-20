package com.sena.crudbasic.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Person")
public class Person {

        @Id
		//anotación para autoincremental
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//indicar que el campo es una columna
		@Column(name="id_person")
		private int id_feria;
		@Column(name="name", length = 70)
		private String name;
        @Column(name="dni")
        private String dni;
        @Column(name="telefono")
        private String telefono;
		
        @OneToMany(mappedBy = "Person")
	    private List<Pavilion> pavilions;

}
