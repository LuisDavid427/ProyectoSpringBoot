package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.ThemeRequestDto;
import com.sena.crudbasic.dto.response.ThemeResponseDto;

public interface ThemeService {

	public List<ThemeResponseDto> findAll();
	public ThemeResponseDto findById(int id);
	public List<ThemeResponseDto> filterByName(String name);
	public String save(ThemeRequestDto t);
	public String delete(int id);
}