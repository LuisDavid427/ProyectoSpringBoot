package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Theme;

@Repository
public interface ThemeRepository 
extends JpaRepository<Theme, Integer>
{
	
	/*
	 * Consulta Derivada: Encuentra Temáticas por nombre, ignorando mayúsculas/minúsculas.
	 */
	public List<Theme> findByThemeNameContainingIgnoreCase(String name);
}