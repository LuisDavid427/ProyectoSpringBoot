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
import com.sena.crudbasic.service.ProductService;
import com.sena.crudbasic.dto.ProductDto;
import com.sena.crudbasic.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<Object>(
            service.findAll(), HttpStatus.OK
        );
    }
    
    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductDto p){
        String result = service.save(p);
        
        // Manejo del error de relación que definimos en el Service
        if (result.startsWith("Error")) {
            return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<Object>(result, HttpStatus.CREATED);
    }
    
    @GetMapping("{id}")
	public ResponseEntity<Object> findById(@PathVariable int id){
		Product product = service.findById(id);
		if (product == null) {
            return new ResponseEntity<Object>("Product not found", HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Object>(product, HttpStatus.OK);
		
	}
    
	@GetMapping("filterbyname/{name}")
	public ResponseEntity<Object> filterByName(@PathVariable String name){
		List <Product> products = service.filterByName(name);
	    return new ResponseEntity<Object>(products, HttpStatus.OK);
	
	}
    
    @GetMapping("filterbystand/{idStand}")
	public ResponseEntity<Object> filterByStandId(@PathVariable int idStand){
		List <Product> products = service.filterByStandId(idStand);
	    return new ResponseEntity<Object>(products, HttpStatus.OK);
	
	}
    
	@DeleteMapping("{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<Object>("Deleted successfully", HttpStatus.OK);
	}
}