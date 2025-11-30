package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.RegistrationService;
import com.sena.crudbasic.dto.RegistrationDto;
import com.sena.crudbasic.model.Registration;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody RegistrationDto r){
        String result = service.save(r);
        
        // Manejo de errores de validación de FK
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Registration registration = service.findById(id);
		if (registration == null) {
            return new ResponseEntity<Object>("Registration not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(registration, HttpStatus.OK);
		
	}
    
    // Filtros por Clave Foránea
    
	@GetMapping("filterbyfair/{idFair}")
	public ResponseEntity<Object> filterByFairId(@PathVariable int idFair){
		List <Registration> registrations = service.filterByFairId(idFair);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}
    
    @GetMapping("filterbystand/{idStand}")
	public ResponseEntity<Object> filterByStandId(@PathVariable int idStand){
		List <Registration> registrations = service.filterByStandId(idStand);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}
    
    @GetMapping("filterbycompany/{idCompany}")
	public ResponseEntity<Object> filterByCompanyId(@PathVariable int idCompany){
		List <Registration> registrations = service.filterByCompanyId(idCompany);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}

    @GetMapping("filterbylecture/{idLecture}")
	public ResponseEntity<Object> filterByLectureId(@PathVariable int idLecture){
		List <Registration> registrations = service.filterByLectureId(idLecture);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}

    @GetMapping("filterbydemonstration/{idDemonstration}")
	public ResponseEntity<Object> filterByDemonstrationId(@PathVariable int idDemonstration){
		List <Registration> registrations = service.filterByDemonstrationId(idDemonstration);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}
    
    @GetMapping("filterbyspeaker/{idSpeaker}")
	public ResponseEntity<Object> filterBySpeakerId(@PathVariable int idSpeaker){
		List <Registration> registrations = service.filterBySpeakerId(idSpeaker);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}

    @GetMapping("filterbyvisitor/{idVisitor}")
	public ResponseEntity<Object> filterByVisitorId(@PathVariable int idVisitor){
		List <Registration> registrations = service.filterByVisitorId(idVisitor);
	    return new ResponseEntity<Object>(registrations, HttpStatus.OK);
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}