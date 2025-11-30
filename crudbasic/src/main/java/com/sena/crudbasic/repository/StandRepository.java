package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Stand;

@Repository
public interface StandRepository 
extends JpaRepository<Stand, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra Stands por nombre.
	 */
	public List<Stand> findByStandNameContainingIgnoreCase(String name);
    
    /*
	 * Consulta Derivada: Busca Stands por el ID del Pabellón al que pertenecen.
	 */
	public List<Stand> findByPavilion_IdPavilion(int idPavilion);
	
	/*
	 * Consulta Derivada: Busca Stands por el ID de la Compañía a la que representan.
	 */
	public List<Stand> findByCompany_IdCompany(int idCompany);
}