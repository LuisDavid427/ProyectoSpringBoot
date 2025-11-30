package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.ThemeDto;
import com.sena.crudbasic.model.Theme;

public interface ThemeService {

	public List<Theme> findAll();
	public Theme findById(int id);
	public List<Theme> filterByName(String name);
	public String save(ThemeDto t);
	public String delete(int id);
}