package cl.awakelab.ejercicio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.awakelab.ejercicio.models.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

	List<Alumno> findAll();
}
