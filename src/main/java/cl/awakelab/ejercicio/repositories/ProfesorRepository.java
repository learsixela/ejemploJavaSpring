package cl.awakelab.ejercicio.repositories;

import cl.awakelab.ejercicio.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Set<Profesor> findAllByNombrecito(String name);
}
