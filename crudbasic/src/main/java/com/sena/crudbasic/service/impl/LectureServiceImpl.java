package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sena.crudbasic.dto.LectureDto;
import com.sena.crudbasic.model.Lecture;
import com.sena.crudbasic.repository.LectureRepository;
import com.sena.crudbasic.service.LectureService;

@Service
public class LectureServiceImpl
implements LectureService {
	
	@Autowired
	private LectureRepository repo;

	@Override
	public List<Lecture> findAll() {
		return this.repo.findAll();
	}

	@Override
	public Lecture findById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Lecture> filterByName(String name) {
		return repo.filterByName(name);
	}
	
	// Conversor DTO -> Model (Garantiza que todos los campos del DTO se asignen)
	public Lecture dtoToModel(LectureDto lectureDto) {
		Lecture lecture = new Lecture();
        lecture.setIdLecture(lectureDto.getIdLecture());
        lecture.setName(lectureDto.getName());
        lecture.setDescription(lectureDto.getDescription());
		return lecture;
	}
	
	// Conversor Model -> DTO
	public LectureDto modelToDto(Lecture lecture) {
		return new LectureDto(
				lecture.getIdLecture(),
				lecture.getName(),
                lecture.getDescription()
				);
	}

	
	@Override
	public String save(LectureDto lectureDto) {
		Lecture lecture = dtoToModel(lectureDto);
		repo.save(lecture);
		return "Saved successfully"; 
	}

	@Override
	public String delete(int id) {
		repo.deleteById(id);
		return "Deleted successfully";
	}
}