package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Fair;
import com.sena.crudbasic.model.Lecture;

@Repository
public interface LectureRepository 
extends JpaRepository<Lecture, Integer>
{
	
	@Query(""
			+ "SELECT "
			+ "l "
			+ "FROM "
			+ "lecture l "
			+ "WHERE "
			+ "l.name like %?1%"
			)
	public List<Lecture>filterByName(String name);
}