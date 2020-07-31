package cl.awakelab.ejercicio.repositories;

import cl.awakelab.ejercicio.models.Conserje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConserjeRepository extends JpaRepository<Conserje, Long> {
}
