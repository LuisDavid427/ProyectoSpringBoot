package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.sena.crudbasic.dto.response.PersonResponseDto;

import com.sena.crudbasic.dto.request.PersonRequestDto;

import com.sena.crudbasic.model.Person;
import com.sena.crudbasic.repository.PersonRepository;
import com.sena.crudbasic.service.PersonService;

@Service
public class PersonServiceImpl
implements PersonService {
	
	@Autowired
	private PersonRepository repo;

	
	// Conversor DTO -> Model
	public Person dtoToModel(PersonRequestDto personDto) {
		Person person = new Person();
        person.setIdPerson(personDto.getIdPerson());
        person.setName(personDto.getName());
        person.setDni(personDto.getDni());
        person.setPhone(personDto.getPhone());
        // Las relaciones (speaker y visitor) se dejan nulas o se establecen en sus propios servicios.
		return person;
	}
	
	// Conversor Model -> DTO
	public PersonResponseDto modelToDto(Person person) {
		return new PersonResponseDto(
				person.getIdPerson(),
				person.getName(),
                person.getDni(),
                person.getPhone()
				);
	}

	
	@Override
	public List<PersonResponseDto> findAll() { // Retorna DTO List
		return this.repo.findAll().stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public PersonResponseDto findById(Integer id) { // Usa Integer ID y retorna DTO
		return repo.findById(id)
			.map(this::modelToDto)
			.orElse(null);
	}

	@Override
	public List<PersonResponseDto> filterByName(String name) { // Retorna DTO List
		return repo.findByName(name).stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}
	@Override
	public List<PersonResponseDto> filterByDni(String dni) { // Retorna DTO List
		return repo.findByDni(dni).stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public String delete(Integer id) { 
		repo.deleteById(id);
		return "Deleted successfully"; 
	}

	
	@Override
	public String save(PersonRequestDto personDto) { // Recibe Request DTO
		Person person = dtoToModel(personDto);
		repo.save(person);
		return "Saved successfully"; 
	}
}