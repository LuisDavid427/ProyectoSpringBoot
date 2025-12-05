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
import com.sena.crudbasic.service.PavilionService;
import com.sena.crudbasic.dto.request.PavilionRequestDto;
import com.sena.crudbasic.dto.response.PavilionResponseDto;
import com.sena.crudbasic.model.Pavilion;

import java.util.List;

@RestController
@RequestMapping("/api/pavilions")
public class PavilionController {

    @Autowired
    private PavilionService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody PavilionRequestDto p){
        String result = service.save(p);
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		PavilionResponseDto pavilion = service.findById(id);
		if (pavilion == null) {
            return new ResponseEntity<Object>("Pavilion not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(pavilion, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <PavilionResponseDto> pavilions = service.filterByName(name);
	    return new ResponseEntity<Object>(pavilions, HttpStatus.OK);
	
	}
    
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}