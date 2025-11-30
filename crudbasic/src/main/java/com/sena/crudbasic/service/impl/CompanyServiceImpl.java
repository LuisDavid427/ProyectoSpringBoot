package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.CompanyDto;
import com.sena.crudbasic.model.Company;
import com.sena.crudbasic.repository.CompanyRepository;
import com.sena.crudbasic.service.CompanyService;

@Service
public class CompanyServiceImpl
implements CompanyService{
	
	@Autowired
	private CompanyRepository repo;

	@Override
	public List<Company> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Company findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Company> filterByCompanyName(String name) {
		return repo.filterByCompanyName(name);
	}
	
	// Conversor del DTO al Model
	public Company dtoToModel(CompanyDto companyDto) {
		Company company = new Company();
        company.setIdCompany(companyDto.getIdCompany());
        company.setCompanyName(companyDto.getCompanyName());
        company.setDescription(companyDto.getDescription());
        // La colección de stands se deja nula/vacía al guardar
		return company;
	}
	
	// Conversor del Model al DTO
	public CompanyDto modelToDto(Company company) {
		return new CompanyDto(
			company.getIdCompany(),
			company.getCompanyName(),
            company.getDescription()
				);
	}

	
	@Override
	public String save(CompanyDto companyDto) {
		Company company = dtoToModel(companyDto);
		repo.save(company);
		return "Saved successfully"; // Mensaje en inglés
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully"; // Mensaje en inglés
	}
}