package com.sena.crudbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.crudbasic.service.FairService;
import com.sena.crudbasic.dto.FairDto;
import com.sena.crudbasic.model.Fair;

import java.util.List;

@RestController
public class FairController {

    @Autowired
    private FairService service;

    @GetMapping("")
    public ResponseEntity<Object>findAll(){
        return new ResponseEntity<Object>(
            service.findAll(),HttpStatus.OK
        );
    }
    @PostMapping("")
    public ResponseEntity<Object>save(@RequestBody FairDto f){
        service.save(f);
            return new ResponseEntity<Object>("Saved successfully",HttpStatus.OK);
        }
    
    @GetMapping("{id}")
	public ResponseEntity<Object>findById(@PathVariable int id){
		Fair fair=service.findById(id);
		return new ResponseEntity<Object>(fair,HttpStatus.OK);
		
	}
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object>filterByName(@PathVariable String name){
		List <Fair> fair=service.filterByName(name);
	return new ResponseEntity<Object>(fair,HttpStatus.OK);
	
	}
	@DeleteMapping("{id}")
	public ResponseEntity<Object>delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully",HttpStatus.OK);
	}

}
