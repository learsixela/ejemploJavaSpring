package cl.awakelab.ejercicio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.awakelab.ejercicio.models.Curso;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
	/*
	 *  select c.id, c.nombre, a.nombre from cursos c
 		INNER JOIN alumnos a on c.alumno_id = a.id
 		where a.id = 1
	 * */
	@Query("select c.id, c.nombre, a.nombre from Curso c "
			+ "JOIN c.alumno a "
			+ "where a.id = ?1 and a.nombre = ?2") 
	Curso buscarPorAlumno(Long id, String nombre);

	// Encontrar todos los cursos a partir de un profesor
	List<Curso> findAllByProfesor_Id(Long idProfesor);
}
