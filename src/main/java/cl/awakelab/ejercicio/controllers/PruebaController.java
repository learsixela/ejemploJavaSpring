package cl.awakelab.ejercicio.controllers;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.models.Prueba;
import cl.awakelab.ejercicio.services.CursoService;
import cl.awakelab.ejercicio.services.PruebaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PruebaController {
    @Autowired
    private CursoService cursoService;

    @Autowired
    private PruebaService pruebaService;

    @Transactional
    @GetMapping("/prueba_curso")
    public String addPrueba() {
        Prueba prueba = new Prueba();
        prueba.setNumeroDePregunta(1);
        prueba.setPregunta("PREGUNTA DE PRUEBA");

        System.out.println(prueba);

        Curso curso = new Curso();
        curso.setDetalle("TEST CURSO");
        curso.setNombre("DETALLE CURSO");

        System.out.println(curso);

        System.out.println("DESPUÉS DE JUNTAR");

        curso.addPrueba(prueba);

        System.out.println(curso);
        System.out.println(prueba);

        Curso dbCurso = cursoService.save(curso);

        Prueba dbPrueba = pruebaService.save(prueba);

        System.out.println("DESPUÉS DE LA TRANSACCIÓN");

        System.out.println(dbCurso);
        System.out.println(dbPrueba);

        return "index.jsp";
    }
}
