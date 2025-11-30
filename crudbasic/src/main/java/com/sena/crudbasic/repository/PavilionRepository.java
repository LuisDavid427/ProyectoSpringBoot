package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Pavilion;

@Repository
public interface PavilionRepository 
extends JpaRepository<Pavilion, Integer>
{
	
	/*
	 * Consulta Derivada: Busca Pabellones por el ID de la Feria a la que pertenecen.
	 * Sintaxis: findBy[NombreAtributoRelacion]_[NombreAtributoPK]
	 */
	public List<Pavilion> findByFair_IdFair(int idFair);
	
	/*
	 * Consulta Derivada: Busca Pabellones por el ID de la Temática a la que pertenecen.
	 */
	public List<Pavilion> findByTheme_IdTheme(int idTheme);
	
	/*
	 * Consulta Derivada estándar para filtrar por nombre.
	 */
    public List<Pavilion> findByNameContainingIgnoreCase(String name);
}