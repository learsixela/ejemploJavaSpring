package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.models.Profesor;
import cl.awakelab.ejercicio.repositories.CursoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PruebaServiceTest {
    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @Test
    public void crearPruebaConCurso() {
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

        Curso dbCurso = cursoRepository.getOne(1L);

        System.out.println(dbCurso);
        
        assertEquals(dbCurso.getProfesor().getId(), dbProfesor.getId());
    }
}
