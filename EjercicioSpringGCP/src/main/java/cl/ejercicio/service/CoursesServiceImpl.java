package cl.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cl.ejercicio.model.dto.CoursesDTO;
import cl.ejercicio.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	CoursesRepository coursesRepository;
	
	@Override
	public List<CoursesDTO> findAll() {
		return coursesRepository.findAll();
	}
	
	@Override
	public List<CoursesDTO> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		Pageable pageableRequest = PageRequest.of(page, limit);
		Page<CoursesDTO> coursesPage = coursesRepository.findAll(pageableRequest);
		List<CoursesDTO> courses = coursesPage.getContent();
		return courses;
	}
	
	@Override
	public CoursesDTO getOne(String code) {
		return coursesRepository.findById(code).get();
	}

	@Override
	public CoursesDTO insert(CoursesDTO coursesDTO) {
		return coursesRepository.save(coursesDTO);
	}

	@Override
	public CoursesDTO update(CoursesDTO coursesDTO) {
		return coursesRepository.save(coursesDTO);
	}

	@Override
	public void delete(CoursesDTO coursesDTO) {
		coursesRepository.delete(coursesDTO);
	}

}
