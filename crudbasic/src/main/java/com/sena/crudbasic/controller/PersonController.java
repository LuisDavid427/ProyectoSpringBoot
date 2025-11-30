package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.PersonService;
import com.sena.crudbasic.dto.PersonDto;
import com.sena.crudbasic.model.Person;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody PersonDto p){
        service.save(p);
        return new ResponseEntity<Object>("Saved successfully", HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Person person = service.findById(id);
		if (person == null) {
            return new ResponseEntity<Object>("Person not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(person, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <Person> people = service.filterByName(name);
	    return new ResponseEntity<Object>(people, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbydni/{dni}")
	public ResponseEntity<Object> findByDni(@PathVariable String dni){
		Person person = service.findByDni(dni);
		if (person == null) {
            return new ResponseEntity<Object>("Person not found with DNI " + dni, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<Object>(person, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}