package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.RegistrationDto;
import com.sena.crudbasic.model.Registration;

public interface RegistrationService {

	public List<Registration> findAll();
	public Registration findById(int id);
    public List<Registration> filterByFairId(int idFair);
    public List<Registration> filterByStandId(int idStand);
    public List<Registration> filterByCompanyId(int idCompany);
    public List<Registration> filterByLectureId(int idLecture);
    public List<Registration> filterByDemonstrationId(int idDemonstration);
    public List<Registration> filterBySpeakerId(int idSpeaker);
    public List<Registration> filterByVisitorId(int idVisitor);
	public String save(RegistrationDto r);
	public String delete(int id);
}