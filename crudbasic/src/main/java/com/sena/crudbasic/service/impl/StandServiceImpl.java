package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.StandDto;
import com.sena.crudbasic.model.Stand;
import com.sena.crudbasic.model.Pavilion;
import com.sena.crudbasic.model.Company;
import com.sena.crudbasic.repository.StandRepository;
import com.sena.crudbasic.repository.PavilionRepository; 
import com.sena.crudbasic.repository.CompanyRepository; 
import com.sena.crudbasic.service.StandService;

@Service
public class StandServiceImpl
implements StandService {
	
	@Autowired
	private StandRepository standRepo;
    
    // Inyectamos los repositorios de las entidades relacionadas
    @Autowired
    private PavilionRepository pavilionRepo; 
    
    @Autowired
    private CompanyRepository companyRepo;

	// Conversor DTO -> Model
	public Stand dtoToModel(StandDto standDto) {
		Stand stand = new Stand();
        stand.setIdStand(standDto.getIdStand());
        stand.setStandName(standDto.getStandName());
        
        // 1. Convertir idPavilion a objeto Pavilion
        Pavilion pavilion = pavilionRepo.findById(standDto.getIdPavilion()).orElse(null);
        stand.setPavilion(pavilion);
        
        // 2. Convertir idCompany a objeto Company
        Company company = companyRepo.findById(standDto.getIdCompany()).orElse(null);
        stand.setCompany(company);
        
		return stand;
	}
    
    // Conversor Model -> DTO
	public StandDto modelToDto(Stand stand) {
        int idPavilion = (stand.getPavilion() != null) ? stand.getPavilion().getIdPavilion() : 0;
        int idCompany = (stand.getCompany() != null) ? stand.getCompany().getIdCompany() : 0;
        
		return new StandDto(
				stand.getIdStand(),
				stand.getStandName(),
                idPavilion,
                idCompany
		);
	}


	@Override
	public List<Stand> findAll() {
		return this.standRepo.findAll();
	}

	@Override
	public Stand findById(int id) {
		return standRepo.findById(id).orElse(null);
	}

	@Override
	public List<Stand> filterByName(String name) {
		return standRepo.findByStandNameContainingIgnoreCase(name);
	}
    
    @Override
	public List<Stand> filterByPavilionId(int idPavilion) {
		return standRepo.findByPavilion_IdPavilion(idPavilion);
	}

    @Override
	public List<Stand> filterByCompanyId(int idCompany) {
		return standRepo.findByCompany_IdCompany(idCompany);
	}

	@Override
	public String save(StandDto standDto) {
		Stand stand = dtoToModel(standDto);
        
        // Validación crucial: las claves foráneas deben existir
        if (stand.getPavilion() == null) {
            return "Error: Pavilion not found with ID " + standDto.getIdPavilion();
        }
        if (stand.getCompany() == null) {
            return "Error: Company not found with ID " + standDto.getIdCompany();
        }
        
		standRepo.save(stand);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		standRepo.deleteById(id);
		return "Deleted successfully";
	}
}