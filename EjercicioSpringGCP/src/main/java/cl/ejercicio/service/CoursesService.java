package cl.ejercicio.service;

import java.util.List;

import cl.ejercicio.model.dto.CoursesDTO;

public interface CoursesService {
	public List<CoursesDTO> findAll();
	public List<CoursesDTO> findAll(int page, int limit);
	public CoursesDTO getOne(String code);
	public CoursesDTO insert(CoursesDTO coursesDTO);
	public CoursesDTO update(CoursesDTO coursesDTO);
	public void delete(CoursesDTO coursesDTO);
	
}
