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
import com.sena.crudbasic.service.ThemeService;
import com.sena.crudbasic.dto.ThemeDto;
import com.sena.crudbasic.model.Theme;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {

    @Autowired
    private ThemeService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ThemeDto t){
        service.save(t);
        return new ResponseEntity<Object>("Saved successfully", HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Theme theme = service.findById(id);
		if (theme == null) {
            return new ResponseEntity<Object>("Theme not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(theme, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <Theme> themes = service.filterByName(name);
	    return new ResponseEntity<Object>(themes, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}