package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.VisitorDto;
import com.sena.crudbasic.model.Visitor;

public interface VisitorService {

	public List<Visitor> findAll();
	public Visitor findById(int id);
    public Visitor findByPersonId(int idPerson);
    public List<Visitor> filterByTypeId(int idType);
	public String save(VisitorDto v);
	public String delete(int id);
}