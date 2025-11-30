package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.DemonstrationDto;
import com.sena.crudbasic.model.Demonstration;
import com.sena.crudbasic.repository.DemonstrationRepository;
import com.sena.crudbasic.service.DemonstrationService;

@Service
public class DemonstrationServiceImpl
implements DemonstrationService {
	
	@Autowired
	private DemonstrationRepository repo;

	@Override
	public List<Demonstration> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Demonstration findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Demonstration> filterByName(String name) {
		// Usamos el método definido en el Repository
		return repo.findByDemonstrationNameContainingIgnoreCase(name);
	}
	
	// Conversor DTO -> Model
	public Demonstration dtoToModel(DemonstrationDto demonstrationDto) {
		Demonstration demonstration = new Demonstration();
        demonstration.setIdDemonstration(demonstrationDto.getIdDemonstration());
        demonstration.setDemonstrationName(demonstrationDto.getDemonstrationName());
        demonstration.setDescription(demonstrationDto.getDescription());
		return demonstration;
	}
	
	// Conversor Model -> DTO (útil para respuestas)
	public DemonstrationDto modelToDto(Demonstration demonstration) {
		return new DemonstrationDto(
				demonstration.getIdDemonstration(),
				demonstration.getDemonstrationName(),
                demonstration.getDescription()
				);
	}

	
	@Override
	public String save(DemonstrationDto demonstrationDto) {
		Demonstration demonstration = dtoToModel(demonstrationDto);
		repo.save(demonstration);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}