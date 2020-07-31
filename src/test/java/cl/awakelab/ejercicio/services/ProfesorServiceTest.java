package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.models.Profesor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProfesorServiceTest {
    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private CursoService cursoService;

    @Transactional
    @Test
    public void crearProfesorConCurso() {
        Profesor profesor = new Profesor();
        profesor.setNombrecito("René");

        System.out.println(profesor);

        Curso curso = new Curso();
        curso.setNombre("DETALLE CURSO");
        curso.setDetalle("TEST CURSO");

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
        
        assertEquals(dbCurso.getProfesor().getId(), dbProfesor.getId());
    }

    @Test
    @Transactional
    public void evaluarCascadaDelProfesor() {
        Profesor profesor = new Profesor();
        profesor.setNombrecito("René");

        System.out.println(profesor);

        Curso curso = new Curso();
        curso.setNombre("DETALLE CURSO");
        curso.setDetalle("TEST CURSO");

        System.out.println(curso);

        profesor.addCurso(curso);

        System.out.println("DESPUÉS DE JUNTAR");
        System.out.println(curso);
        System.out.println(profesor);

        Profesor dbProfesor = profesorService.save(profesor);
        Long idProfesor = dbProfesor.getId();

        Curso dbCurso = cursoService.findOne(2L);

        System.out.println("DESPUÉS DE LA TRANSACCIÓN");
        System.out.println(dbProfesor);
        System.out.println(dbCurso);

        // BORRAR PROFESOR Y CURSO DEBERÍA PERSISTIR

        profesorService.delete(dbProfesor.getId());

        dbCurso = cursoService.findOne(2L);
        List<Profesor> dbProfesores = profesorService.findAll();

        System.out.println("DESPUÉS DE BORRAR PROFESOR");

//        System.out.println(dbProfesor);
        System.out.println("PROFESORES: " + dbProfesores);
        System.out.println("CURSO: " + dbCurso);

        assertNull(dbCurso.getProfesor());
    }
}
