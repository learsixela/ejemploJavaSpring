package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Curso;
import cl.awakelab.ejercicio.models.Profesor;
import cl.awakelab.ejercicio.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {
    /*
		En este servicio implementamos el CRUD completo,
		pero eso es netamente de ejemplo, uno puede insertar
		lo que quiera (cuestiones lógicas).
	 */

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CursoService cursoService;

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Profesor findOne(Long id) {
        return profesorRepository.findById(id)
                .orElse(null);
    }

    public void update(Profesor profesor) {
//        Profesor dbProfesor = findOne(profesor.getId());
//
//        if (!profesor.getNombrecito().equals(dbProfesor.getNombrecito()))
//            dbProfesor.setNombrecito(profesor.getNombrecito());

//        profesorRepository.save(dbProfesor);

        profesorRepository.save(profesor);
    }

    /*
        Este método se preocupa de evitar que cuando eliminamos un profesor
        queden cursos con profesores inexistentes, algo importante para la
        integridad de los datos (concepto de bases de datos).
    */
    public void delete(Long id) {
        List<Curso> cursos = cursoService.findAllByProfesorId(id);
        for (Curso curso: cursos) {
            curso.setProfesor(null);
        }
        profesorRepository.deleteById(id);
    }
}
