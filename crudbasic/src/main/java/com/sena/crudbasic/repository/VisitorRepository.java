package com.sena.crudbasic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Visitor;

@Repository
public interface VisitorRepository 
extends JpaRepository<Visitor, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra un Visitor por el ID de la Persona a la que representa (One-to-One).
	 */
	public Optional<Visitor> findByPerson_IdPerson(int idPerson);
    
    /*
	 * Consulta Derivada: Encuentra Visitors por el ID de su Tipo (Many-to-One).
	 */
    public List<Visitor> findByVisitorType_IdType(int idType);
}