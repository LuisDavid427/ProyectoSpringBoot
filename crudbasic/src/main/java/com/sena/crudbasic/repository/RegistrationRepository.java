package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Registration;

@Repository
public interface RegistrationRepository 
extends JpaRepository<Registration, Integer>
{
	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.fair = ?1"
			)
	public List<Registration> findByIdFair(int idFair);
	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.stand = ?1"
			)
    public List<Registration> findByIdStand(int idStand);
    	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.company = ?1"
			)
    public List<Registration> findByIdCompany(int idCompany);
    	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.lecture = ?1"
			)
    public List<Registration> findByIdLecture(int idLecture);
    	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.demonstration = ?1"
			)
    public List<Registration> findByIdDemonstration(int idDemonstration);
    	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.speaker = ?1"
			)
    public List<Registration> findByIdSpeaker(int idSpeaker);
    	
			@Query(""
			+ "SELECT "
			+ "r "
			+ "FROM "
			+ "registration r "
			+ "WHERE "
			+ "r.visitor = ?1"
			)
    public List<Registration> findByIdVisitor(int idVisitor);
}