package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.DemonstrationRequestDto;
import com.sena.crudbasic.dto.response.DemonstrationResponseDto;
import com.sena.crudbasic.model.Demonstration;
import com.sena.crudbasic.repository.DemonstrationRepository;
import com.sena.crudbasic.service.DemonstrationService;

@Service
public class DemonstrationServiceImpl implements DemonstrationService {
	
	@Autowired
	private DemonstrationRepository repo;

	public Demonstration dtoToModel(DemonstrationRequestDto demonstrationDto) {
		Demonstration demonstration = new Demonstration();
        demonstration.setIdDemonstration(demonstrationDto.getIdDemonstration());
        demonstration.setName(demonstrationDto.getName());
        demonstration.setDescription(demonstrationDto.getDescription());
		return demonstration;
	}
	
	public DemonstrationResponseDto modelToDto(Demonstration demonstration) {
		return new DemonstrationResponseDto(
			demonstration.getIdDemonstration(),
			demonstration.getName(),
            demonstration.getDescription()
			);
	}

	@Override
	public List<DemonstrationResponseDto> findAll() {
		return this.repo.findAll().stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}

    @Override
    public DemonstrationResponseDto findById(Integer id) {
        return repo.findById(id)
                .map(this::modelToDto)
                .orElse(null);
    }
	
	@Override
	public String save(DemonstrationRequestDto companyRequestDto) {
		Demonstration company = dtoToModel(companyRequestDto);
		repo.save(company);
		return "Saved successfully"; 
	}


	@Override
	public String delete(Integer id) { 
		repo.deleteById(id);
		return "Deleted successfully"; 
	}
    


	@Override
	public List<DemonstrationResponseDto> filterByName(String name) {
		return repo.filterByName(name).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}
}