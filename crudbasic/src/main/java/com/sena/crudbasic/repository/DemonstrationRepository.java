package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Demonstration;
import com.sena.crudbasic.model.Fair;

@Repository
public interface DemonstrationRepository 
extends JpaRepository<Demonstration, Integer>
{
	@Query(""
			+ "SELECT "
			+ "d "
			+ "FROM "
			+ "demonstration d "
			+ "WHERE "
			+ "d.name like %?1%"
			)
	public List<Demonstration>filterByName(String name);
}