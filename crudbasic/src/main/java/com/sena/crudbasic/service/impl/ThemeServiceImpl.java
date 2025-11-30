package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.ThemeDto;
import com.sena.crudbasic.model.Theme;
import com.sena.crudbasic.repository.ThemeRepository;
import com.sena.crudbasic.service.ThemeService;

@Service
public class ThemeServiceImpl
implements ThemeService {
	
	@Autowired
	private ThemeRepository repo;

	@Override
	public List<Theme> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Theme findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Theme> filterByName(String name) {
		return repo.findByThemeNameContainingIgnoreCase(name);
	}
	
	// Conversor DTO -> Model
	public Theme dtoToModel(ThemeDto themeDto) {
		Theme theme = new Theme();
        theme.setIdTheme(themeDto.getIdTheme());
        theme.setThemeName(themeDto.getThemeName());
        // No hay campo 'description' en esta entidad, solo 'themeName'
		return theme;
	}
	
	// Conversor Model -> DTO
	public ThemeDto modelToDto(Theme theme) {
		return new ThemeDto(
				theme.getIdTheme(),
				theme.getThemeName()
				);
	}

	
	@Override
	public String save(ThemeDto themeDto) {
		Theme theme = dtoToModel(themeDto);
		repo.save(theme);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}