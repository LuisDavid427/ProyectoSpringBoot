package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.StandRequestDto;
import com.sena.crudbasic.dto.response.StandResponseDto;

public interface StandService {

	public List<StandResponseDto> findAll();
	public StandResponseDto findById(int id);
	public List<StandResponseDto> filterByName(String name);
    public List<StandResponseDto> filterByPavilionId(int idPavilion);
    public List<StandResponseDto> filterByCompanyId(int idCompany);
	public String save(StandRequestDto s);
	public String delete(int id);
}