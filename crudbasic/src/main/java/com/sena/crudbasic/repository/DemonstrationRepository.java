package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Demonstration;

@Repository
public interface DemonstrationRepository 
extends JpaRepository<Demonstration, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra Demostraciones por nombre, sin distinguir mayúsculas/minúsculas.
	 * Spring genera la consulta JPQL automáticamente.
	 */
	public List<Demonstration> findByDemonstrationNameContainingIgnoreCase(String name);
}