package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaRepository;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    @Transactional
    public PlanetaEntity createPlaneta(PlanetaEntity entity) throws IllegalOperationException {

        String nombre = entity.getNombre();

        if (!(nombre.endsWith("I") || nombre.endsWith(" II") || nombre.endsWith(" III"))) {
        throw new IllegalOperationException("El nombre del planeta debe terminar en numero romano");
        }
        if (entity.getPoblacion() <= 0) {
            throw new IllegalOperationException("La población debe tener mas que 0 habitantes");
        }

        PlanetaEntity guardado = planetaRepository.save(entity);

        return guardado;
    }
}
