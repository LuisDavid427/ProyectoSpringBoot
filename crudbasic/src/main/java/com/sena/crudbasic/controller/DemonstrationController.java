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

import com.sena.crudbasic.service.DemonstrationService;
import com.sena.crudbasic.dto.request.DemonstrationRequestDto;
import com.sena.crudbasic.model.Demonstration;

import java.util.List;

import com.sena.crudbasic.dto.response.DemonstrationResponseDto;

@RestController
@RequestMapping("/api/demonstrations")
public class DemonstrationController {

    @Autowired
    private DemonstrationService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody DemonstrationRequestDto d){
        service.save(d);
        return new ResponseEntity<Object>("Saved successfully", HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		DemonstrationResponseDto demonstration = service.findById(id);
		if (demonstration == null) {
            return new ResponseEntity<Object>("Demonstration not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(demonstration, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <DemonstrationResponseDto> demonstrations = service.filterByName(name);
	    return new ResponseEntity<Object>(demonstrations, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}