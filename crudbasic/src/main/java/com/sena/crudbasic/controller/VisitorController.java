package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.VisitorService;
import com.sena.crudbasic.dto.VisitorDto;
import com.sena.crudbasic.model.Visitor;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private VisitorService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody VisitorDto v){
        String result = service.save(v);
        
        // Manejo de errores de validación de FK y One-to-One
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Visitor visitor = service.findById(id);
		if (visitor == null) {
            return new ResponseEntity<Object>("Visitor not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(visitor, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyperson/{idPerson}")
	public ResponseEntity<Object> findByPersonId(@PathVariable int idPerson){
		Visitor visitor = service.findByPersonId(idPerson);
		if (visitor == null) {
            return new ResponseEntity<Object>("Visitor not found for Person ID: " + idPerson, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<Object>(visitor, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbytype/{idType}")
	public ResponseEntity<Object> filterByTypeId(@PathVariable int idType){
		List <Visitor> visitors = service.filterByTypeId(idType);
	    return new ResponseEntity<Object>(visitors, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}