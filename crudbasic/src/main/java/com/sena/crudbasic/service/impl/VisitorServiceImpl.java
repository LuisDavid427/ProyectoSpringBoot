package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.sena.crudbasic.dto.VisitorDto;
import com.sena.crudbasic.model.Visitor;
import com.sena.crudbasic.model.Person;
import com.sena.crudbasic.model.VisitorType; // Asumimos esta clase model
import com.sena.crudbasic.repository.VisitorRepository;
import com.sena.crudbasic.repository.PersonRepository; 
import com.sena.crudbasic.repository.VisitorTypeRepository; // Asumimos esta dependencia
import com.sena.crudbasic.service.VisitorService;

@Service
public class VisitorServiceImpl
implements VisitorService {
	
	@Autowired
	private VisitorRepository visitorRepo;
    
    @Autowired
    private PersonRepository personRepo; 

    @Autowired
    private VisitorTypeRepository visitorTypeRepo;

	// Conversor DTO -> Model
	public Visitor dtoToModel(VisitorDto visitorDto) {
		Visitor visitor = new Visitor();
        visitor.setIdVisitor(visitorDto.getIdVisitor());
        
        // 1. Convertir idPerson a objeto Person
        Person person = personRepo.findById(visitorDto.getIdPerson()).orElse(null);
        visitor.setPerson(person);

        // 2. Convertir idVisitorType a objeto VisitorType
        VisitorType visitorType = visitorTypeRepo.findById(visitorDto.getIdVisitorType()).orElse(null);
        visitor.setVisitorType(visitorType);
        
		return visitor;
	}
    
    // Conversor Model -> DTO
	public VisitorDto modelToDto(Visitor visitor) {
        int idPerson = (visitor.getPerson() != null) ? visitor.getPerson().getIdPerson() : 0;
        int idVisitorType = (visitor.getVisitorType() != null) ? visitor.getVisitorType().getIdType() : 0;
        
		return new VisitorDto(
				visitor.getIdVisitor(),
                idPerson,
                idVisitorType
		);
	}


	@Override
	public List<Visitor> findAll() {
		return this.visitorRepo.findAll();
	}

	@Override
	public Visitor findById(int id) {
		return visitorRepo.findById(id).orElse(null);
	}

    @Override
	public Visitor findByPersonId(int idPerson) {
		return visitorRepo.findByPerson_IdPerson(idPerson).orElse(null);
	}
    
    @Override
	public List<Visitor> filterByTypeId(int idType) {
		return visitorRepo.findByVisitorType_IdType(idType);
	}

	@Override
	public String save(VisitorDto visitorDto) {
		Visitor visitor = dtoToModel(visitorDto);
        
        // --- Validación de las relaciones ---
        
        // 1. Validar que la Persona exista
        if (visitor.getPerson() == null) {
            return "Error: Person not found with ID " + visitorDto.getIdPerson();
        }
        
        // 2. Validar que el VisitorType exista
        if (visitor.getVisitorType() == null) {
            return "Error: VisitorType not found with ID " + visitorDto.getIdVisitorType();
        }
        
        // 3. Validar restricción Uno a Uno (que la Persona no sea ya otro Visitor)
        Optional<Visitor> existingVisitor = visitorRepo.findByPerson_IdPerson(visitorDto.getIdPerson());
        
        if (existingVisitor.isPresent()) {
            if (visitorDto.getIdVisitor() == 0 || existingVisitor.get().getIdVisitor() != visitorDto.getIdVisitor()) {
                return "Error: Person with ID " + visitorDto.getIdPerson() + " is already registered as a Visitor.";
            }
        }
        
        // 4. Establecer la relación bidireccional en la entidad Person
        visitor.getPerson().setVisitor(visitor);
        
		visitorRepo.save(visitor);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
        Optional<Visitor> visitor = visitorRepo.findById(id);
        if (visitor.isPresent()) {
            // Eliminar la referencia en la entidad Person antes de borrar el Visitor
            Person person = visitor.get().getPerson();
            if (person != null) {
                person.setVisitor(null);
            }
        }
		visitorRepo.deleteById(id);
		return "Deleted successfully";
	}
}