package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.StandDto;
import com.sena.crudbasic.model.Stand;

public interface StandService {

	public List<Stand> findAll();
	public Stand findById(int id);
	public List<Stand> filterByName(String name);
    public List<Stand> filterByPavilionId(int idPavilion);
    public List<Stand> filterByCompanyId(int idCompany);
	public String save(StandDto s);
	public String delete(int id);
}