package cl.awakelab.ejercicio.repositories;

import cl.awakelab.ejercicio.models.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {
}
