package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.VisitorTypeRequestDto;
import com.sena.crudbasic.dto.response.VisitorTypeResponseDto;

public interface VisitorTypeService {

	public List<VisitorTypeResponseDto> findAll();
	public VisitorTypeResponseDto findById(int id);
	public List<VisitorTypeResponseDto> filterByName(String name);
	public String save(VisitorTypeRequestDto vt);
	public String delete(int id);
}