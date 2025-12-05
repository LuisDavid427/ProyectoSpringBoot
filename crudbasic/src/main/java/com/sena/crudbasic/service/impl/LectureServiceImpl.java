package com.sena.crudbasic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

import com.sena.crudbasic.dto.request.LectureRequestDto;
import com.sena.crudbasic.dto.response.LectureResponseDto;
import com.sena.crudbasic.model.Lecture;
import com.sena.crudbasic.repository.LectureRepository;
import com.sena.crudbasic.service.LectureService;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureRepository repo;

	public Lecture dtoToModel(LectureRequestDto fairDto) {
		Lecture lecture = new Lecture();
        lecture.setIdLecture(fairDto.getIdLecture());
        lecture.setName(fairDto.getName());
        lecture.setDescription(fairDto.getDescription());
		return lecture;
	}
	
	public LectureResponseDto modelToDto(Lecture lecture) {
		return new LectureResponseDto(
			lecture.getIdLecture(),
			lecture.getName(),
            lecture.getDescription()
			);
	}

	@Override
	public List<LectureResponseDto> findAll() {
		return this.repo.findAll().stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}

    @Override
    public LectureResponseDto findById(Integer id) {
        return repo.findById(id)
                .map(this::modelToDto)
                .orElse(null);
    }
	
	@Override
	public String save(LectureRequestDto companyRequestDto) {
		Lecture company = dtoToModel(companyRequestDto);
		repo.save(company);
		return "Saved successfully"; 
	}


	@Override
	public String delete(Integer id) { 
		repo.deleteById(id);
		return "Deleted successfully"; 
	}
    


	@Override
	public List<LectureResponseDto> filterByName(String name) {
		return repo.filterByName(name).stream()
            .map(this::modelToDto)
            .collect(Collectors.toList());
	}
}