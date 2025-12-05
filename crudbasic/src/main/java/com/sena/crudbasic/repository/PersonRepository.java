package com.sena.crudbasic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Fair;
import com.sena.crudbasic.model.Person;

@Repository
public interface PersonRepository 
extends JpaRepository<Person, Integer>
{
	
		@Query(""
			+ "SELECT "
			+ "p "
			+ "FROM "
			+ " person p "
			+ "WHERE "
			+ "p.name like %?1%"
			)
	
	public List<Person> findByName(String name);
    
	@Query(""
			+ "SELECT "
			+ "p "
			+ "FROM "
			+ "person p "
			+ "WHERE "
			+ "p.dni like %?1%"
			)
    public List<Person> findByDni(String dni);
}