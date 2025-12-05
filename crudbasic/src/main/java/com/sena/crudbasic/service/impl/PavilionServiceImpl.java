package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors; // Importación para usar stream().collect(Collectors.toList())

// Solo importamos los DTOs de Request y Response
import com.sena.crudbasic.dto.request.PavilionRequestDto; 
import com.sena.crudbasic.dto.response.PavilionResponseDto; 

import com.sena.crudbasic.model.Pavilion;
import com.sena.crudbasic.repository.PavilionRepository;
import com.sena.crudbasic.service.PavilionService;

@Service
public class PavilionServiceImpl implements PavilionService {
	
	@Autowired
	private PavilionRepository repo;

	// Conversor Request DTO -> Model (Simplificado)
	public Pavilion dtoToModel(PavilionRequestDto pavilionDto) {
		Pavilion pavilion = new Pavilion();
		pavilion.setIdPavilion(pavilionDto.getIdPavilion());
		pavilion.setName(pavilionDto.getName());
		

		
		return pavilion;
	}
	
	// Conversor Model -> Response DTO (Simplificado)
	public PavilionResponseDto modelToDto(Pavilion pavilion) {
		return new PavilionResponseDto(
				pavilion.getIdPavilion(),
				pavilion.getName(),
				pavilion.getTheme() != null ? pavilion.getTheme().getIdTheme() : 0,
				pavilion.getFair() != null ? pavilion.getFair().getIdFair() : 0,
				pavilion.getStands()
		);
	}


	@Override
	public List<PavilionResponseDto> findAll() { // Retorna DTO List
		return this.repo.findAll().stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public PavilionResponseDto findById(Integer id) { // Usa Integer ID y retorna DTO
		return repo.findById(id)
			.map(this::modelToDto)
			.orElse(null);
	}

	@Override
	public List<PavilionResponseDto> filterByName(String name) { // Retorna DTO List
		return repo.findByName(name).stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	
	@Override
	public String save(PavilionRequestDto pavilionDto) { // Recibe Request DTO
		Pavilion pavilion = dtoToModel(pavilionDto);
		repo.save(pavilion);
		return "Saved successfully"; 
	}

	@Override
	public String delete(Integer id) { // Usa Integer ID
		repo.deleteById(id);
		return "Deleted successfully";
	}
}