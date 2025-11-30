package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.SpeakerService;
import com.sena.crudbasic.dto.SpeakerDto;
import com.sena.crudbasic.model.Speaker;

import java.util.List;

@RestController
@RequestMapping("/api/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody SpeakerDto s){
        String result = service.save(s);
        
        // Manejo de errores de validación de FK y One-to-One
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Speaker speaker = service.findById(id);
		if (speaker == null) {
            return new ResponseEntity<Object>("Speaker not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(speaker, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyperson/{idPerson}")
	public ResponseEntity<Object> findByPersonId(@PathVariable int idPerson){
		Speaker speaker = service.findByPersonId(idPerson);
		if (speaker == null) {
            return new ResponseEntity<Object>("Speaker not found for Person ID: " + idPerson, HttpStatus.NOT_FOUND);
        }
	    return new ResponseEntity<Object>(speaker, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}