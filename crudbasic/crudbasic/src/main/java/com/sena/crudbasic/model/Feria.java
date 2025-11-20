package com.sena.crudbasic.model;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="Feria")
public class Feria {
        @Id
		//anotación para autoincremental
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		//indicar que el campo es una columna
		@Column(name="id_feria")
		private int id_feria;
		@Column(name="name", length = 60)
		private String name;
        @Column(name="description")
        private String description;
		
        @OneToMany(mappedBy = "Feria")
	    private List<Pavilion> pavilions;

}
