package com.sena.crudbasic.service;

import java.util.List;
import com.sena.crudbasic.dto.PersonDto;
import com.sena.crudbasic.model.Person;

public interface PersonService {

	public List<Person> findAll();
	public Person findById(int id);
	public List<Person> filterByName(String name);
    public Person findByDni(String dni);
	public String save(PersonDto p);
	public String delete(int id);
}