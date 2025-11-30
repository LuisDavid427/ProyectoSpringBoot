package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.ProductDto;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.model.Stand;
import com.sena.crudbasic.repository.ProductRepository;
import com.sena.crudbasic.repository.StandRepository; // Asumimos esta dependencia
import com.sena.crudbasic.service.ProductService;

@Service
public class ProductServiceImpl
implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
    
    // Necesitamos el repositorio de la entidad Stand
    @Autowired
    private StandRepository standRepo; 

	// Conversor DTO -> Model
	public Product dtoToModel(ProductDto productDto) {
		Product product = new Product();
        product.setIdProduct(productDto.getIdProduct());
        product.setName(productDto.getName());
        
        // Convertir el idStand a objeto Stand
        Stand stand = standRepo.findById(productDto.getIdStand()).orElse(null);
        product.setStand(stand);
        
		return product;
	}
    
    // Conversor Model -> DTO
	public ProductDto modelToDto(Product product) {
        int idStand = (product.getStand() != null) ? product.getStand().getIdStand() : 0;
        
		return new ProductDto(
				product.getIdProduct(),
				product.getName(),
                idStand
		);
	}


	@Override
	public List<Product> findAll() {
		return this.productRepo.findAll();
	}

	@Override
	public Product findById(int id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public List<Product> filterByName(String name) {
		return productRepo.findByProductNameContainingIgnoreCase(name);
	}
    
    @Override
	public List<Product> filterByStandId(int idStand) {
		return productRepo.findByStand_IdStand(idStand);
	}

	@Override
	public String save(ProductDto productDto) {
		Product product = dtoToModel(productDto);
        
        // Validación de relación antes de guardar
        if (product.getStand() == null) {
            return "Error: Stand not found with ID " + productDto.getIdStand();
        }
        
		productRepo.save(product);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		productRepo.deleteById(id);
		return "Deleted successfully";
	}
}