package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.ResponsibleDto;
import com.sena.crudbasic.model.Responsible;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.model.Person;
import com.sena.crudbasic.repository.ResponsibleRepository;
import com.sena.crudbasic.repository.ProductRepository; 
import com.sena.crudbasic.repository.PersonRepository; 
import com.sena.crudbasic.service.ResponsibleService;

@Service
public class ResponsibleServiceImpl
implements ResponsibleService {
	
	@Autowired
	private ResponsibleRepository responsibleRepo;
    
    // Inyectamos los repositorios de las entidades relacionadas
    @Autowired
    private ProductRepository productRepo; 
    
    @Autowired
    private PersonRepository personRepo;

	// Conversor DTO -> Model
	public Responsible dtoToModel(ResponsibleDto responsibleDto) {
		Responsible responsible = new Responsible();
        responsible.setIdResponsible(responsibleDto.getIdResponsible());
        
        // 1. Convertir idProduct a objeto Product
        Product product = productRepo.findById(responsibleDto.getIdProduct()).orElse(null);
        responsible.setProduct(product);
        
        // 2. Convertir idPerson a objeto Person
        Person person = personRepo.findById(responsibleDto.getIdPerson()).orElse(null);
        responsible.setPerson(person);
        
		return responsible;
	}
    
    // Conversor Model -> DTO
	public ResponsibleDto modelToDto(Responsible responsible) {
        int idProduct = (responsible.getProduct() != null) ? responsible.getProduct().getIdProduct() : 0;
        int idPerson = (responsible.getPerson() != null) ? responsible.getPerson().getIdPerson() : 0;
        
		return new ResponsibleDto(
				responsible.getIdResponsible(),
                idProduct,
                idPerson
		);
	}


	@Override
	public List<Responsible> findAll() {
		return this.responsibleRepo.findAll();
	}

	@Override
	public Responsible findById(int id) {
		return responsibleRepo.findById(id).orElse(null);
	}

	@Override
	public List<Responsible> filterByPersonId(int idPerson) {
		return responsibleRepo.findByPerson_IdPerson(idPerson);
	}

    @Override
	public List<Responsible> filterByProductId(int idProduct) {
		return responsibleRepo.findByProduct_IdProduct(idProduct);
	}

	@Override
	public String save(ResponsibleDto responsibleDto) {
		// 1. Convertir y validar las FK
        Responsible responsible = dtoToModel(responsibleDto);
        
        if (responsible.getProduct() == null) {
            return "Error: Product not found with ID " + responsibleDto.getIdProduct();
        }
        if (responsible.getPerson() == null) {
            return "Error: Person not found with ID " + responsibleDto.getIdPerson();
        }
        
        // 2. Validación de duplicidad (opcional pero recomendado en tablas pivote)
        Responsible existing = responsibleRepo.findByPerson_IdPersonAndProduct_IdProduct(
            responsibleDto.getIdPerson(), 
            responsibleDto.getIdProduct());
        
        if (existing != null && responsibleDto.getIdResponsible() == 0) {
            return "Error: The person is already responsible for this product.";
        }
        
        // Si el idResponsible es 0 (nuevo registro), pero ya existe una combinación, se rechaza.
        // Si el idResponsible es > 0, es una actualización, y se permite.
        
		responsibleRepo.save(responsible);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		responsibleRepo.deleteById(id);
		return "Deleted successfully";
	}
}