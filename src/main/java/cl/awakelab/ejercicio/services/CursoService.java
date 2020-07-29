package cl.awakelab.ejercicio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.repositories.CursoRepository;

@Service
public class CursoService {
	@Autowired
	private CursoRepository cr;
	
	public Curso obtenerCurso(Long id) {
		return cr.findById(id).orElse(null);
	}

}
