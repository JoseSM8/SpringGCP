package cl.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ejercicio.model.dto.StudentsDTO;

public interface StudentsRepository extends JpaRepository<StudentsDTO, String> {

}
