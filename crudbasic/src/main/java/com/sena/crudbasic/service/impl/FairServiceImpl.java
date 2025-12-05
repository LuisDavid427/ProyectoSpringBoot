package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.FairRequestDto;
import com.sena.crudbasic.dto.response.FairResponseDto;
import com.sena.crudbasic.model.Fair;
import com.sena.crudbasic.repository.FairRepository;
import com.sena.crudbasic.service.FairService;

@Service
public class FairServiceImpl implements FairService {
	
	@Autowired
	private FairRepository repo;

	public Fair dtoToModel(FairRequestDto fairDto) {
		Fair fair = new Fair();
        fair.setIdFair(fairDto.getIdFair());
        fair.setName(fairDto.getName());
        fair.setDescription(fairDto.getDescription());
		return fair;
	}
	
	public FairResponseDto modelToDto(Fair fair) {
		return new FairResponseDto(
			fair.getIdFair(),
			fair.getName(),
            fair.getDescription(),
			null
			);
	}

	@Override
	public List<FairResponseDto> findAll() {
		return this.repo.findAll().stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}

    @Override
    public FairResponseDto findById(Integer id) {
        return repo.findById(id)
                .map(this::modelToDto)
                .orElse(null);
    }
	
	@Override
	public String save(FairRequestDto companyRequestDto) {
		Fair company = dtoToModel(companyRequestDto);
		repo.save(company);
		return "Saved successfully"; 
	}


	@Override
	public String delete(Integer id) { 
		repo.deleteById(id);
		return "Deleted successfully"; 
	}
    


	@Override
	public List<FairResponseDto> filterByName(String name) {
		return repo.filterByName(name).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}
}