package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Prueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaService {
    @Autowired
    private PruebaService pruebaService;

    public Prueba save(Prueba prueba) {
        return pruebaService.save(prueba);
    }
}
