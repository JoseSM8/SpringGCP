package cl.ejercicio.service;

import java.util.List;

import cl.ejercicio.model.dto.StudentsDTO;

public interface StudentsService {
	public List<StudentsDTO> findAll();
	public List<StudentsDTO> findAll(int page, int limit);
	public StudentsDTO getOne(String rut);
	public StudentsDTO insert(StudentsDTO studentsDTO);
	public StudentsDTO update(StudentsDTO studentsDTO);
	public void delete(StudentsDTO studentsDTO);
}
