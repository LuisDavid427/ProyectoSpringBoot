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
import com.sena.crudbasic.service.CompanyService;
import com.sena.crudbasic.dto.CompanyDto;
import com.sena.crudbasic.model.Company;

import java.util.List;

@RestController
@RequestMapping("/api/companies") // Agregamos un mapping base para organizar
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CompanyDto c){
        service.save(c);
        return new ResponseEntity<Object>("Saved successfully",HttpStatus.CREATED); // Usamos 201 Created
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Company company = service.findById(id);
		if (company == null) {
            return new ResponseEntity<Object>("Company not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(company, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByCompanyName(@PathVariable String name){
		List <Company> companies = service.filterByCompanyName(name);
	    return new ResponseEntity<Object>(companies, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}