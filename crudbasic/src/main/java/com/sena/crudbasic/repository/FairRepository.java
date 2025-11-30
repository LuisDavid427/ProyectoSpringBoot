package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Fair;

@Repository
public interface FairRepository 
extends JpaRepository<Fair, Integer>
{
	/*JpaRepository
	 * Incluye las consultas basicas
	 * Para una consulta personalizada
	 * es requerido definir el método  necesario
	 * 
	 */
	
	@Query(""
			+ "SELECT "
			+ "f "
			+ "FROM "
			+ "fair f "
			+ "WHERE "
			+ "f.name like %?1%"
			)
	public List<Fair>filterByName(String name);
	
	/*
	 * @Query(""
			+ "SELECT "
			+ "s "
			+ "FROM "
			+ "student s "
			+ "WHERE "
			+ "s.first_name=?1 OR "
			+ "s.last_name=?2"
			
			)
	public List<Fair>filterByName(
	String firstName,String lastName);
	
	 */

}
