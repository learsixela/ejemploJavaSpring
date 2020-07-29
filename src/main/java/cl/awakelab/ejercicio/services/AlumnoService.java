package cl.awakelab.ejercicio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.awakelab.ejercicio.models.Alumno;
import cl.awakelab.ejercicio.repositories.AlumnoRepository;

@Service
public class AlumnoService {
	@Autowired
	AlumnoRepository alRepo;

	public List<Alumno> obtenerTodosLosAlumnos() {
		// TODO Auto-generated method stub
		return alRepo.findAll();
	}
	


}
