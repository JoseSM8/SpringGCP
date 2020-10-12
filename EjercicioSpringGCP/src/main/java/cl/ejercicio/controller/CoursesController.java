package cl.ejercicio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import cl.ejercicio.model.dto.CoursesDTO;
import cl.ejercicio.service.CoursesService;

@RestController
public class CoursesController {

	@Autowired
	CoursesService coursesService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<CoursesDTO>> listPageable(
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="limit", defaultValue="2") int limit){
		List<CoursesDTO> list = coursesService.findAll(page, limit);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/courses/all")
	public ResponseEntity<List<CoursesDTO>> list(){
		List<CoursesDTO> list = coursesService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/courses/{code}")
	public ResponseEntity<CoursesDTO> get(@PathVariable("code") String code){
		try {
			CoursesDTO course = coursesService.getOne(code);
			return ResponseEntity.ok().body(course);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error getting course");
		}
	}
	
	@PostMapping("/courses")
	public ResponseEntity<?> insert(@Valid @RequestBody CoursesDTO coursesDTO){
		CoursesDTO course = coursesService.insert(coursesDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(course);
	}
	
	@PutMapping("/courses/{code}")
	public ResponseEntity<?> update(@PathVariable("code") String code, @RequestBody CoursesDTO coursesDTO){
		try {
			CoursesDTO course = coursesService.getOne(code);
			course.setName(coursesDTO.getName());
			
			CoursesDTO updatedCourse = coursesService.insert(course);
			return ResponseEntity.ok().body(updatedCourse);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error updating course");
		}
		
	}
	
	@DeleteMapping("/courses/{code}")
	public ResponseEntity<?> delete(@PathVariable("code") String code) {
		try {
			CoursesDTO course = coursesService.getOne(code);
			coursesService.delete(course);
			return ResponseEntity.ok().body("Course has been deleted");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error deleting course");
		}
		
	}
}
