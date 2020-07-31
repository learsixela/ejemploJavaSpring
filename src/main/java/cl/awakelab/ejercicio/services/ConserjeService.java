package cl.awakelab.ejercicio.services;

import cl.awakelab.ejercicio.models.Conserje;
import cl.awakelab.ejercicio.repositories.ConserjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConserjeService {
    @Autowired
    private ConserjeRepository conserjeRepository;

    public Conserje save(Conserje conserje) {
        return conserjeRepository.save(conserje);
    }

    public List<Conserje> findAll() {
        return conserjeRepository.findAll();
    }

    public Conserje findOne(Long id) {
        return conserjeRepository.getOne(id);
    }

    public void update(Conserje conserje) {
        conserjeRepository.save(conserje);
    }

    public void delete(Long id) {
        conserjeRepository.deleteById(id);
    }
}
