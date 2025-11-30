package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.sena.crudbasic.dto.SpeakerDto;
import com.sena.crudbasic.model.Speaker;
import com.sena.crudbasic.model.Person;
import com.sena.crudbasic.repository.SpeakerRepository;
import com.sena.crudbasic.repository.PersonRepository; // Asumimos esta dependencia
import com.sena.crudbasic.service.SpeakerService;

@Service
public class SpeakerServiceImpl
implements SpeakerService {
	
	@Autowired
	private SpeakerRepository speakerRepo;
    
    @Autowired
    private PersonRepository personRepo; 

	// Conversor DTO -> Model
	public Speaker dtoToModel(SpeakerDto speakerDto) {
		Speaker speaker = new Speaker();
        speaker.setIdSpeaker(speakerDto.getIdSpeaker());
        
        // 1. Convertir idPerson a objeto Person
        Person person = personRepo.findById(speakerDto.getIdPerson()).orElse(null);
        speaker.setPerson(person);
        
		return speaker;
	}
    
    // Conversor Model -> DTO
	public SpeakerDto modelToDto(Speaker speaker) {
        int idPerson = (speaker.getPerson() != null) ? speaker.getPerson().getIdPerson() : 0;
        
		return new SpeakerDto(
				speaker.getIdSpeaker(),
                idPerson
		);
	}


	@Override
	public List<Speaker> findAll() {
		return this.speakerRepo.findAll();
	}

	@Override
	public Speaker findById(int id) {
		return speakerRepo.findById(id).orElse(null);
	}

    @Override
	public Speaker findByPersonId(int idPerson) {
		return speakerRepo.findByPerson_IdPerson(idPerson).orElse(null);
	}

	@Override
	public String save(SpeakerDto speakerDto) {
		Speaker speaker = dtoToModel(speakerDto);
        
        // --- Validación de la relación Uno a Uno ---
        
        // 1. Validar que la Persona exista
        if (speaker.getPerson() == null) {
            return "Error: Person not found with ID " + speakerDto.getIdPerson();
        }
        
        // 2. Validar que la Persona no esté ya asociada a otro Speaker
        Optional<Speaker> existingSpeaker = speakerRepo.findByPerson_IdPerson(speakerDto.getIdPerson());
        
        if (existingSpeaker.isPresent()) {
            // Si ya existe y es un nuevo registro (idSpeaker == 0), o si el ID es diferente, es un error.
            if (speakerDto.getIdSpeaker() == 0 || existingSpeaker.get().getIdSpeaker() != speakerDto.getIdSpeaker()) {
                return "Error: Person with ID " + speakerDto.getIdPerson() + " is already registered as a Speaker.";
            }
        }
        
        // 3. Establecer la relación bidireccional en la entidad Person (si Person tiene el setter)
        // Aunque no es estrictamente necesario para la persistencia, es una buena práctica.
        speaker.getPerson().setSpeaker(speaker);
        
		speakerRepo.save(speaker);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
        Optional<Speaker> speaker = speakerRepo.findById(id);
        if (speaker.isPresent()) {
            // Eliminar la referencia en la entidad Person antes de borrar el Speaker
            Person person = speaker.get().getPerson();
            if (person != null) {
                person.setSpeaker(null);
            }
        }
		speakerRepo.deleteById(id);
		return "Deleted successfully";
	}
}