package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.StandService;
import com.sena.crudbasic.dto.StandDto;
import com.sena.crudbasic.model.Stand;

import java.util.List;

@RestController
@RequestMapping("/api/stands")
public class StandController {

    @Autowired
    private StandService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody StandDto s){
        String result = service.save(s);
        
        // Manejo del error de relación
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Stand stand = service.findById(id);
		if (stand == null) {
            return new ResponseEntity<Object>("Stand not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(stand, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <Stand> stands = service.filterByName(name);
	    return new ResponseEntity<Object>(stands, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbypavilion/{idPavilion}")
	public ResponseEntity<Object> filterByPavilionId(@PathVariable int idPavilion){
		List <Stand> stands = service.filterByPavilionId(idPavilion);
	    return new ResponseEntity<Object>(stands, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbycompany/{idCompany}")
	public ResponseEntity<Object> filterByCompanyId(@PathVariable int idCompany){
		List <Stand> stands = service.filterByCompanyId(idCompany);
	    return new ResponseEntity<Object>(stands, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}