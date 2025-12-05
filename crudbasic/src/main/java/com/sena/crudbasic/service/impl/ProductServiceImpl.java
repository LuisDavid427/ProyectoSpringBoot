package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.ProductRequestDto;
import com.sena.crudbasic.dto.response.PersonResponseDto;
import com.sena.crudbasic.dto.response.ProductResponseDto;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.model.Stand;
import com.sena.crudbasic.repository.ProductRepository;
import com.sena.crudbasic.repository.StandRepository; 
import com.sena.crudbasic.service.ProductService;

@Service
public class ProductServiceImpl
implements ProductService {
	
	@Autowired
	private ProductRepository repo;
    
    // Necesitamos el repositorio de la entidad Stand
    @Autowired
    private StandRepository standRepo; 

	// Conversor DTO -> Model
	public Product dtoToModel(ProductRequestDto productDto) {
		Product product = new Product();
        product.setIdProduct(productDto.getIdProduct());
        product.setName(productDto.getName());
        
        // Convertir el idStand a objeto Stand
        Stand stand = standRepo.findById(productDto.getIdStand()).orElse(null);
        product.setStand(stand);
        
		return product;
	}
    
    // Conversor Model -> DTO
	public ProductResponseDto modelToDto(Product product) {
        int idStand = (product.getStand() != null) ? product.getStand().getIdStand() : 0;
        
		return new ProductResponseDto(
				product.getIdProduct(),
				product.getName(),
                idStand
		);
	}

	@Override
	public List<ProductResponseDto> findAll() { // Retorna DTO List
		return this.repo.findAll().stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public ProductResponseDto findById(Integer id) { // Usa Integer ID y retorna DTO
		return repo.findById(id)
			.map(this::modelToDto)
			.orElse(null);
	}

	@Override
	public List<ProductResponseDto> filterByName(String name) { // Retorna DTO List
		return repo.findByName(name).stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}
    
    @Override
	public List<ProductResponseDto> filterByStandId(int idStand) { // Retorna DTO List
		return repo.filterByIdStand(idStand).stream()
			.map(this::modelToDto)
			.collect(Collectors.toList());
	}

	@Override
	public String save(ProductRequestDto productDto) {
		Product product = dtoToModel(productDto);
        
        // Validación de relación antes de guardar
        if (product.getStand() == null) {
            return "Error: Stand not found with ID " + productDto.getIdStand();
        }
        
		repo.save(product);
		return "Saved successfully"; 
	}

	@Override
	public String delete(Integer id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}