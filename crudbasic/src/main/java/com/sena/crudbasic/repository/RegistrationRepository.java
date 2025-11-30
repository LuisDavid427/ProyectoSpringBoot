package com.sena.crudbasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.crudbasic.model.Registration;

@Repository
public interface RegistrationRepository 
extends JpaRepository<Registration, Integer>
{
	
	/*
	 * Consultas Derivadas: Busca Registros por IDs de entidades relacionadas.
	 */
	public List<Registration> findByFair_IdFair(int idFair);
    public List<Registration> findByStand_IdStand(int idStand);
    public List<Registration> findByCompany_IdCompany(int idCompany);
    public List<Registration> findByLecture_IdLecture(int idLecture);
    public List<Registration> findByDemonstration_IdDemonstration(int idDemonstration);
    public List<Registration> findBySpeaker_IdSpeaker(int idSpeaker);
    public List<Registration> findByVisitor_IdVisitor(int idVisitor);
}