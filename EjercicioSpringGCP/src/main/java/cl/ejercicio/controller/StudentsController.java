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

import cl.ejercicio.model.dto.StudentsDTO;
import cl.ejercicio.service.StudentsService;

@RestController
public class StudentsController {

	@Autowired
	StudentsService studentsService; 
	
	@GetMapping("/students")
	public ResponseEntity<List<StudentsDTO>> listPageable(
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="limit", defaultValue="2") int limit){
		List<StudentsDTO> list = studentsService.findAll(page, limit);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/students/all")
	public ResponseEntity<List<StudentsDTO>> list(){
		List<StudentsDTO> list = studentsService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/students/{rut}")
	public ResponseEntity<StudentsDTO> get(@PathVariable("rut") String rut){
		try {
			StudentsDTO student = studentsService.getOne(rut);
			return ResponseEntity.ok().body(student);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error getting student");
		}
	}
	
	@PostMapping("/students")
	public ResponseEntity<?> insert(@Valid @RequestBody StudentsDTO studentsDTO){
		StudentsDTO	student = studentsService.insert(studentsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
	
	@PutMapping("/students/{rut}")
	public ResponseEntity<?> update(@PathVariable("rut") String rut, @RequestBody StudentsDTO studentsDTO){
		try {
			StudentsDTO student = studentsService.getOne(rut);
			student.setName(studentsDTO.getName());
			student.setLastName(studentsDTO.getLastName());
			student.setAge(studentsDTO.getAge());
			student.setCourse(studentsDTO.getCourse());
			
			StudentsDTO	updatedStudent = studentsService.insert(student);
			return ResponseEntity.ok().body(updatedStudent);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error updating student");
		}
		
	}
	
	@DeleteMapping("/students/{rut}")
	public ResponseEntity<?> delete(@PathVariable("rut") String rut) {
		try {
			StudentsDTO student = studentsService.getOne(rut);
			studentsService.delete(student);
			return ResponseEntity.ok().body("Student has been deleted");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Error deleting student");
		}
		
	}
}
