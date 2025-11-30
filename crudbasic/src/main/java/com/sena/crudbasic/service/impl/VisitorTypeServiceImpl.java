package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.VisitorTypeDto;
import com.sena.crudbasic.model.VisitorType;
import com.sena.crudbasic.repository.VisitorTypeRepository;
import com.sena.crudbasic.service.VisitorTypeService;

@Service
public class VisitorTypeServiceImpl
implements VisitorTypeService {
	
	@Autowired
	private VisitorTypeRepository repo;

	// Conversor DTO -> Model
	public VisitorType dtoToModel(VisitorTypeDto visitorTypeDto) {
		VisitorType visitorType = new VisitorType();
        visitorType.setIdType(visitorTypeDto.getIdType());
        visitorType.setTypeName(visitorTypeDto.getTypeName());
		return visitorType;
	}
    
    // Conversor Model -> DTO
	public VisitorTypeDto modelToDto(VisitorType visitorType) {
		return new VisitorTypeDto(
				visitorType.getIdType(),
				visitorType.getTypeName()
		);
	}


	@Override
	public List<VisitorType> findAll() {
		return this.repo.findAll();
	}

	@Override
	public VisitorType findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<VisitorType> filterByName(String name) {
		return repo.findByTypeNameContainingIgnoreCase(name);
	}

	@Override
	public String save(VisitorTypeDto visitorTypeDto) {
		VisitorType visitorType = dtoToModel(visitorTypeDto);
		repo.save(visitorType);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}