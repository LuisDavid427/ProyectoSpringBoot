package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.RegistrationRequestDto;
import com.sena.crudbasic.dto.response.RegistrationResponseDto;
import com.sena.crudbasic.model.*;
import com.sena.crudbasic.repository.*;
import com.sena.crudbasic.service.RegistrationService;

@Service
public class RegistrationServiceImpl
implements RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
    
    // Inyección de los 7 repositorios dependientes
    @Autowired private FairRepository fairRepo; 
    @Autowired private StandRepository standRepo; 
    @Autowired private CompanyRepository companyRepo; 
    @Autowired private LectureRepository lectureRepo;
    @Autowired private DemonstrationRepository demonstrationRepo;
    @Autowired private SpeakerRepository speakerRepo;
    @Autowired private VisitorRepository visitorRepo;

	// Conversor DTO -> Model
	public Registration dtoToModel(RegistrationRequestDto dto) {
		Registration reg = new Registration();
        reg.setIdRegistration(dto.getIdRegistration());
        
        // Asignación y conversión de las 7 claves foráneas
        reg.setFair(fairRepo.findById(dto.getIdFair()).orElse(null));
        reg.setStand(standRepo.findById(dto.getIdStand()).orElse(null));
        reg.setCompany(companyRepo.findById(dto.getIdCompany()).orElse(null));
        reg.setLecture(lectureRepo.findById(dto.getIdLecture()).orElse(null));
        reg.setDemonstration(demonstrationRepo.findById(dto.getIdDemonstration()).orElse(null));
        reg.setSpeaker(speakerRepo.findById(dto.getIdSpeaker()).orElse(null));
        reg.setVisitor(visitorRepo.findById(dto.getIdVisitor()).orElse(null));
        
		return reg;
	}
    
    // Conversor Model -> DTO
	public RegistrationResponseDto modelToDto(Registration reg) {
        // Uso de operadores ternarios para evitar NullPointerException si la FK es nula
        int idFair = (reg.getFair() != null) ? reg.getFair().getIdFair() : 0;
        int idStand = (reg.getStand() != null) ? reg.getStand().getIdStand() : 0;
        int idCompany = (reg.getCompany() != null) ? reg.getCompany().getIdCompany() : 0;
        int idLecture = (reg.getLecture() != null) ? reg.getLecture().getIdLecture() : 0;
        int idDemonstration = (reg.getDemonstration() != null) ? reg.getDemonstration().getIdDemonstration() : 0;
        int idSpeaker = (reg.getSpeaker() != null) ? reg.getSpeaker().getIdSpeaker() : 0;
        int idVisitor = (reg.getVisitor() != null) ? reg.getVisitor().getIdVisitor() : 0;
        
		return new RegistrationResponseDto(
				reg.getIdRegistration(),
                idFair, idStand, idCompany, idLecture, idDemonstration, idSpeaker, idVisitor
		);
	}


	@Override
	public List<RegistrationResponseDto> findAll() {
		return this.repo.findAll().stream()
        .map(this::modelToDto)
        .collect(Collectors.toList());
	}

	@Override
	public RegistrationResponseDto findById(Integer id) {
		return repo.findById(id)
        .map(this::modelToDto)
        .orElse(null);
	}
    @Override
    public List<RegistrationResponseDto> filterByName(String name) {
        // Este método no es aplicable para Registration, pero debe implementarse
        return List.of(); // Retorna una lista vacía
    }

    // Implementación de métodos de filtro para todas las FK
    @Override
    public List<RegistrationResponseDto> filterByFairId(int idFair) {
        return repo.findByIdFair(idFair).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterByStandId(int idStand) {
        return repo.findByIdStand(idStand).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterByCompanyId(int idCompany) {
        return repo.findByIdCompany(idCompany).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterByLectureId(int idLecture) {
        return repo.findByIdLecture(idLecture).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterByDemonstrationId(int idDemonstration) {
        return repo.findByIdDemonstration(idDemonstration).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterBySpeakerId(int idSpeaker) {
        return repo.findByIdSpeaker(idSpeaker).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<RegistrationResponseDto> filterByVisitorId(int idVisitor) {
        return repo.findByIdVisitor(idVisitor).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
    }

	@Override
	public String save(RegistrationRequestDto dto) {
		Registration reg = dtoToModel(dto);
        
        // *** Validación de las 7 claves foráneas (crucial) ***
        if (reg.getFair() == null && dto.getIdFair() != 0) return "Error: Fair not found with ID " + dto.getIdFair();
        if (reg.getStand() == null && dto.getIdStand() != 0) return "Error: Stand not found with ID " + dto.getIdStand();
        if (reg.getCompany() == null && dto.getIdCompany() != 0) return "Error: Company not found with ID " + dto.getIdCompany();
        if (reg.getLecture() == null && dto.getIdLecture() != 0) return "Error: Lecture not found with ID " + dto.getIdLecture();
        if (reg.getDemonstration() == null && dto.getIdDemonstration() != 0) return "Error: Demonstration not found with ID " + dto.getIdDemonstration();
        if (reg.getSpeaker() == null && dto.getIdSpeaker() != 0) return "Error: Speaker not found with ID " + dto.getIdSpeaker();
        if (reg.getVisitor() == null && dto.getIdVisitor() != 0) return "Error: Visitor not found with ID " + dto.getIdVisitor();

        // Nota: Asumimos que no todas las FK son obligatorias (pueden ser 0 en el DTO). 
        // Si deben ser obligatorias, se debe eliminar la condición `&& dto.getIdXXX() != 0`.
        
		repo.save(reg);
		return "Saved successfully"; 
	}

	@Override
	public String delete(Integer id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}