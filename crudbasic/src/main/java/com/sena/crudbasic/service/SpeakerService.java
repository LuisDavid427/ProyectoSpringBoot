package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.SpeakerDto;
import com.sena.crudbasic.model.Speaker;

public interface SpeakerService {

	public List<Speaker> findAll();
	public Speaker findById(int id);
    public Speaker findByPersonId(int idPerson);
	public String save(SpeakerDto s);
	public String delete(int id);
}