package cl.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ejercicio.model.dto.CoursesDTO;

public interface CoursesRepository extends JpaRepository<CoursesDTO, String> {

}
