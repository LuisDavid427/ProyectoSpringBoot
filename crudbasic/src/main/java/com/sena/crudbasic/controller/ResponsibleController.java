package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.ResponsibleService;
import com.sena.crudbasic.dto.ResponsibleDto;
import com.sena.crudbasic.model.Responsible;

import java.util.List;

@RestController
@RequestMapping("/api/responsibles")
public class ResponsibleController {

    @Autowired
    private ResponsibleService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ResponsibleDto r){
        String result = service.save(r);
        
        // Manejo de errores de validación y de FK
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Responsible responsible = service.findById(id);
		if (responsible == null) {
            return new ResponseEntity<Object>("Responsible mapping not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(responsible, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyperson/{idPerson}")
	public ResponseEntity<Object> filterByPersonId(@PathVariable int idPerson){
		List <Responsible> responsibles = service.filterByPersonId(idPerson);
	    return new ResponseEntity<Object>(responsibles, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbyproduct/{idProduct}")
	public ResponseEntity<Object> filterByProductId(@PathVariable int idProduct){
		List <Responsible> responsibles = service.filterByProductId(idProduct);
	    return new ResponseEntity<Object>(responsibles, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}