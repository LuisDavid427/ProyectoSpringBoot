package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.PavilionDto;
import com.sena.crudbasic.model.Pavilion;
import com.sena.crudbasic.model.Fair;
import com.sena.crudbasic.model.Theme;
import com.sena.crudbasic.repository.PavilionRepository;
import com.sena.crudbasic.repository.FairRepository; // Asumimos esta dependencia
import com.sena.crudbasic.repository.ThemeRepository; // Asumimos esta dependencia
import com.sena.crudbasic.service.PavilionService;

@Service
public class PavilionServiceImpl
implements PavilionService {
	
	@Autowired
	private PavilionRepository pavilionRepo;
    
    // Necesitamos los repositorios de las entidades relacionadas
    @Autowired
    private FairRepository fairRepo; 
    
    @Autowired
    private ThemeRepository themeRepo;

	// Conversor DTO -> Model
	public Pavilion dtoToModel(PavilionDto pavilionDto) {
		Pavilion pavilion = new Pavilion();
        pavilion.setIdPavilion(pavilionDto.getIdPavilion());
        pavilion.setName(pavilionDto.getName());
        
        // 1. Convertir el idFair a objeto Fair
        Fair fair = fairRepo.findById(pavilionDto.getIdFair()).orElse(null);
        pavilion.setFair(fair);
        
        // 2. Convertir el idTheme a objeto Theme
        Theme theme = themeRepo.findById(pavilionDto.getIdTheme()).orElse(null);
        pavilion.setTheme(theme);
        
		return pavilion;
	}
    
    // Conversor Model -> DTO
	public PavilionDto modelToDto(Pavilion pavilion) {
        int idFair = (pavilion.getFair() != null) ? pavilion.getFair().getIdFair() : 0;
        int idTheme = (pavilion.getTheme() != null) ? pavilion.getTheme().getIdTheme() : 0;
        
		return new PavilionDto(
				pavilion.getIdPavilion(),
				pavilion.getName(),
                idTheme,
                idFair
		);
	}


	@Override
	public List<Pavilion> findAll() {
		return this.pavilionRepo.findAll();
	}

	@Override
	public Pavilion findById(int id) {
		return pavilionRepo.findById(id).orElse(null);
	}

	@Override
	public List<Pavilion> filterByName(String name) {
		return pavilionRepo.findByNameContainingIgnoreCase(name);
	}
    
    @Override
	public List<Pavilion> filterByFairId(int idFair) {
		return pavilionRepo.findByFair_IdFair(idFair);
	}

	@Override
	public String save(PavilionDto pavilionDto) {
		Pavilion pavilion = dtoToModel(pavilionDto);
        
        // Validación de relaciones antes de guardar
        if (pavilion.getFair() == null) {
            return "Error: Fair not found with ID " + pavilionDto.getIdFair();
        }
        if (pavilion.getTheme() == null) {
            return "Error: Theme not found with ID " + pavilionDto.getIdTheme();
        }
        
		pavilionRepo.save(pavilion);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		pavilionRepo.deleteById(id);
		return "Deleted successfully";
	}
}