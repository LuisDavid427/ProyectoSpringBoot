package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.DemonstrationDto;
import com.sena.crudbasic.model.Demonstration;

public interface DemonstrationService {

	public List<Demonstration> findAll();
	public Demonstration findById(int id);
	public List<Demonstration> filterByName(String name);
	public String save(DemonstrationDto d);
	public String delete(int id);
}