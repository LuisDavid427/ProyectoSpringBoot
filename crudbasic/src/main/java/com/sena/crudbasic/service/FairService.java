package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.FairDto;
import com.sena.crudbasic.model.Fair;

public interface FairService {

	/*
	 * findAll
	 * findById
	 * filterByName
	 * save
	 * delete
	 */
	public List<Fair> findAll();
	public Fair findById(int id);
	public List<Fair> filterByName(String name);
	public String save(FairDto f);
	public String delete(int id);
}
