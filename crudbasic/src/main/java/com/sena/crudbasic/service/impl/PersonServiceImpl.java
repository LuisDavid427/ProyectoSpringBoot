package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.PersonDto;
import com.sena.crudbasic.model.Person;
import com.sena.crudbasic.repository.PersonRepository;
import com.sena.crudbasic.service.PersonService;

@Service
public class PersonServiceImpl
implements PersonService {
	
	@Autowired
	private PersonRepository repo;

	@Override
	public List<Person> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Person findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Person> filterByName(String name) {
		return repo.findByNameContainingIgnoreCase(name);
	}
    
    @Override
	public Person findByDni(String dni) {
		return repo.findByDni(dni).orElse(null);
	}
	
	// Conversor DTO -> Model
	public Person dtoToModel(PersonDto personDto) {
		Person person = new Person();
        person.setIdPerson(personDto.getIdPerson());
        person.setName(personDto.getName());
        person.setDni(personDto.getDni());
        person.setPhone(personDto.getPhone());
        // Las relaciones (speaker y visitor) se dejan nulas o se establecen en sus propios servicios.
		return person;
	}
	
	// Conversor Model -> DTO
	public PersonDto modelToDto(Person person) {
		return new PersonDto(
				person.getIdPerson(),
				person.getName(),
                person.getDni(),
                person.getPhone()
				);
	}

	
	@Override
	public String save(PersonDto personDto) {
		Person person = dtoToModel(personDto);
		repo.save(person);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}