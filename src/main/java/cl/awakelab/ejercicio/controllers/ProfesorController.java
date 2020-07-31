package cl.awakelab.ejercicio.controllers;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.models.Profesor;
import cl.awakelab.ejercicio.services.CursoService;
import cl.awakelab.ejercicio.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private CursoService cursoService;


    @Transactional
    @GetMapping("/profesor-add")
    public String addProfesor() {
        Profesor profesor = new Profesor();
        profesor.setNombrecito("René");

        System.out.println(profesor);

        Curso curso = new Curso();
        curso.setDetalle("TEST CURSO");
        curso.setNombre("DETALLE CURSO");

        System.out.println(curso);

        profesor.addCurso(curso);

        System.out.println("DESPUÉS DE JUNTAR");
        System.out.println(curso);
        System.out.println(profesor);

        Profesor dbProfesor = profesorService.save(profesor);

        System.out.println("DESPUÉS DE LA TRANSACCIÓN");

        System.out.println(dbProfesor);

        Curso dbCurso = cursoService.findOne(1L);

        System.out.println(dbCurso);

        return "index.jsp";
    }
}
