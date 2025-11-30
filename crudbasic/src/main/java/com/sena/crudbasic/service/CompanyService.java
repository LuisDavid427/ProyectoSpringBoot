package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.CompanyDto;
import com.sena.crudbasic.model.Company;

public interface CompanyService {

	public List<Company> findAll();
	public Company findById(int id);
	public List<Company> filterByCompanyName(String name);
	public String save(CompanyDto c);
	public String delete(int id);
}