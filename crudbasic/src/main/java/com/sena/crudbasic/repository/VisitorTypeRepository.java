package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.VisitorType;

@Repository
public interface VisitorTypeRepository 
extends JpaRepository<VisitorType, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra Tipos de Visitante por nombre.
	 */
	public List<VisitorType> findByTypeNameContainingIgnoreCase(String name);
}