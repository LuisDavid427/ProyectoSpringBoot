package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.PavilionDto;
import com.sena.crudbasic.model.Pavilion;

public interface PavilionService {

	public List<Pavilion> findAll();
	public Pavilion findById(int id);
	public List<Pavilion> filterByName(String name);
	public List<Pavilion> filterByFairId(int idFair);
	public String save(PavilionDto p);
	public String delete(int id);
}