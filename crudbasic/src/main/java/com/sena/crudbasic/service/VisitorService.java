package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.VisitorRequestDto;
import com.sena.crudbasic.dto.response.VisitorResponseDto;

public interface VisitorService {

	public List<VisitorResponseDto> findAll();
	public VisitorResponseDto findById(int id);
    public VisitorResponseDto findByPersonId(int idPerson);
    public List<VisitorResponseDto> filterByTypeId(int idType);
	public String save(VisitorRequestDto v);
	public String delete(int id);
}