package com.sena.crudbasic.service;

import java.util.List;

import com.sena.crudbasic.dto.LectureDto;
import com.sena.crudbasic.model.Lecture;

public interface LectureService {

	public List<Lecture> findAll();
	public Lecture findById(int id);
	public List<Lecture> filterByName(String name);
	public String save(LectureDto l);
	public String delete(int id);
}