package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


import com.sena.crudbasic.dto.FairDto;
import com.sena.crudbasic.model.Fair;
import com.sena.crudbasic.repository.FairRepository;
import com.sena.crudbasic.service.FairService;

@Service
public class FairServiceImpl
implements FairService{
	
	@Autowired
	private FairRepository repo;
	/*
	public FairServiceImpl(FairRepository repo) {
		this.repo=repo;
	}
	*/

	@Override
	public List<Fair> findAll() {
		
		return this.repo.findAll();
	}

	@Override
	public Fair findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Fair> filterByName(String name) {
		// TODO Auto-generated method stub
		return repo.filterByName(name);
	}
	//conversor del DTO al model
	public Fair dtoToModel(FairDto fairDto) {
		return new Fair 
				(
				fairDto.getIdFair(),
				fairDto.getName(),
				null,
                null
		);
	}
	public FairDto modelToDto(Fair fair) {
		return new FairDto(
				fair.getIdFair(),
				fair.getName(),
                null
				);
	}

	
	@Override
	public String save(FairDto fairDto) {
		Fair fair=dtoToModel(fairDto);
		repo.save(fair);
		return null;
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return null;
	}

}


