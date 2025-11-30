package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.VisitorTypeService;
import com.sena.crudbasic.dto.VisitorTypeDto;
import com.sena.crudbasic.model.VisitorType;

import java.util.List;

@RestController
@RequestMapping("/api/visitortypes")
public class VisitorTypeController {

    @Autowired
    private VisitorTypeService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody VisitorTypeDto vt){
        service.save(vt);
        return new ResponseEntity<Object>("Saved successfully", HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		VisitorType visitorType = service.findById(id);
		if (visitorType == null) {
            return new ResponseEntity<Object>("Visitor Type not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(visitorType, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <VisitorType> visitorTypes = service.filterByName(name);
	    return new ResponseEntity<Object>(visitorTypes, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}