package cl.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.ejercicio.model.dto.StudentsDTO;
import cl.ejercicio.repository.StudentsRepository;

@Service
public class StudentsServiceImpl implements StudentsService {

	@Autowired
	StudentsRepository studentsRepository;
	
	@Override
	public List<StudentsDTO> findAll() {
		return studentsRepository.findAll();
	}
	
	@Override
	public List<StudentsDTO> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<StudentsDTO> studentsPage = studentsRepository.findAll(pageableRequest);
		List<StudentsDTO> students = studentsPage.getContent();
		return students;
	}
	
	@Override
	public StudentsDTO getOne(String rut) {
		return studentsRepository.findById(rut).get();
	}

	@Override
	public StudentsDTO insert(StudentsDTO studentsDTO) {
		return studentsRepository.save(studentsDTO);
	}

	@Override
	public StudentsDTO update(StudentsDTO studentsDTO) {
		return studentsRepository.save(studentsDTO);
	}

	@Override
	public void delete(StudentsDTO studentsDTO) {
		studentsRepository.delete(studentsDTO);
	}

}
