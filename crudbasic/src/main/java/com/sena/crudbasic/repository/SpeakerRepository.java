package com.sena.crudbasic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Speaker;

@Repository
public interface SpeakerRepository 
extends JpaRepository<Speaker, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra un Speaker por el ID de la Persona a la que representa.
	 * Usamos Optional<Speaker> para asegurar que solo puede haber un Speaker por Persona.
	 */
	public Optional<Speaker> findByPerson_IdPerson(int idPerson);
}