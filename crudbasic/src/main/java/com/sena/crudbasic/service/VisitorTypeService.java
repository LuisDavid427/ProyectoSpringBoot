package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.VisitorTypeDto;
import com.sena.crudbasic.model.VisitorType;

public interface VisitorTypeService {

	public List<VisitorType> findAll();
	public VisitorType findById(int id);
	public List<VisitorType> filterByName(String name);
	public String save(VisitorTypeDto vt);
	public String delete(int id);
}