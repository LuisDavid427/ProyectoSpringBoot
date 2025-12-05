package com.sena.crudbasic.service;


import java.util.List;

import com.sena.crudbasic.dto.request.PersonRequestDto;

import com.sena.crudbasic.dto.response.PersonResponseDto;
import com.sena.crudbasic.model.Person;

public interface PersonService extends GenericService <PersonRequestDto, PersonResponseDto, Integer>{

    List<PersonResponseDto> filterByDni(String dni);

}