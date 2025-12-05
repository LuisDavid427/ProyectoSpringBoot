package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Pavilion;

@Repository
public interface PavilionRepository 
extends JpaRepository<Pavilion, Integer>
{
		@Query(""
			+ "SELECT "
			+ "p "
			+ "FROM "
			+ "pavilion p "
			+ "WHERE "
			+ "p.name like %?1%"
			)
    public List<Pavilion> findByName(String name);
}