package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.CompanyRequestDto;
import com.sena.crudbasic.dto.response.CompanyResponseDto;
import com.sena.crudbasic.model.Company;
import com.sena.crudbasic.repository.CompanyRepository;
import com.sena.crudbasic.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository repo;

	public Company dtoToModel(CompanyRequestDto companyDto) {
		Company company = new Company();
        company.setIdCompany(companyDto.getIdCompany());
        company.setName(companyDto.getName());
        company.setDescription(companyDto.getDescription());
		return company;
	}
	
	public CompanyResponseDto modelToDto(Company company) {
		return new CompanyResponseDto(
			company.getIdCompany(),
			company.getName(),
            company.getDescription()
			);
	}

	@Override
	public List<CompanyResponseDto> findAll() {
		return this.repo.findAll().stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}

    @Override
    public CompanyResponseDto findById(Integer id) {
        return repo.findById(id)
                .map(this::modelToDto)
                .orElse(null);
    }
	
	@Override
	public String save(CompanyRequestDto companyRequestDto) {
		Company company = dtoToModel(companyRequestDto);
		repo.save(company);
		return "Saved successfully"; 
	}


	@Override
	public String delete(Integer id) { 
		repo.deleteById(id);
		return "Deleted successfully"; 
	}
    


	@Override
	public List<CompanyResponseDto> filterByName(String name) {
		return repo.filterByName(name).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}
}