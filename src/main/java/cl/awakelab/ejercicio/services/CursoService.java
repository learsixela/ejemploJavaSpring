package cl.awakelab.ejercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.repositories.CursoRepository;

import java.util.List;

@Service
public class CursoService {
	/*
		En este servicio implementamos el CRUD completo,
		pero eso es netamente de ejemplo, uno puede insertar
		lo que quiera (cuestiones lógicas).
	 */

	@Autowired
	private CursoRepository cursoRepository;
	
	public Curso findOne(Long id) {
		return cursoRepository.findById(id).orElse(null);
	}

	public List<Curso> finAll() {
		return cursoRepository.findAll();
	}

	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	public void update(Curso curso) {
		cursoRepository.save(curso);
	}

	public void delete(Long id) {
		cursoRepository.deleteById(id);
	}

	public List<Curso> findAllByProfesorId(Long idProfesor) {
		return cursoRepository.findAllByProfesor_Id(idProfesor);
	}

}
