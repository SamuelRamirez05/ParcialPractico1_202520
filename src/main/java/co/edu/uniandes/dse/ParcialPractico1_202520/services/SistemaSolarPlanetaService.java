package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.PlanetaRepository;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;

@Service
public class SistemaSolarPlanetaService {

    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    @Autowired
    private PlanetaRepository planetaRepository;

    @Transactional
    public PlanetaEntity associatePlanetaSistemaSolar(Long planetaId, Long sistemaSolarId) throws IllegalOperationException {
        
        PlanetaEntity planeta = planetaRepository.findById(planetaId).get();
        SistemaSolar sistema = sistemaSolarRepository.findById(sistemaSolarId).get();

        long poblacionActual = 0;
        for (PlanetaEntity poblacionPlaneta : sistema.getPlanetas()) {
            poblacionActual = poblacionActual + poblacionPlaneta.getPoblacion();
        }

        long poblacion = poblacionActual + planeta.getPoblacion();
        double ratioActual = sistema.getNumeroStorm() / (double) poblacion;

        if (ratioActual < sistema.getRatioFuerzaMin()) {
            throw new IllegalOperationException("El ratio actual sería menor al del sistema solar");
        }

        planeta.setSistemaSolar(sistema);

        
        return planetaRepository.save(planeta);
    }
}
