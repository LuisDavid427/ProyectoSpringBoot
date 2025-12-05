package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.request.SpeakerRequestDto;
import com.sena.crudbasic.dto.response.SpeakerResponseDto;

public interface SpeakerService {

	public List<SpeakerResponseDto> findAll();
	public SpeakerResponseDto findById(int id);
    public SpeakerResponseDto findByPersonId(int idPerson);
	public String save(SpeakerRequestDto s);
	public String delete(int id);
}