package cl.awakelab.ejercicio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.awakelab.ejercicio.models.Alumno;
import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.services.AlumnoService;
import cl.awakelab.ejercicio.services.CursoService;

@Controller
public class HomeController {
	@Autowired
	public CursoService cs;
	
	@Autowired
	public AlumnoService als;
	
	@RequestMapping("/")
	public String home(Model model) {
		Curso curso = cs.obtenerCurso(1L);
		List<Alumno> alumnos = als.obtenerTodosLosAlumnos();
		
		model.addAttribute("curso",curso);
		model.addAttribute("listaAlumnos",alumnos);
		return "index.jsp";
	}
}
