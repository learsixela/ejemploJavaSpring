package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Profesor;
import cl.awakelab.ejercicio.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }
}
