package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.ParcialPractico1_202520.repositories.SistemaSolarRepository;

@Service
public class SistemaSolarService {

    @Autowired
    private SistemaSolarRepository sistemaSolarRepository;

    @Transactional
    public SistemaSolar createSistemaSolar(SistemaSolar entity) throws IllegalOperationException {

    
        if (entity.getNombre().length() >= 31) {
            throw new IllegalOperationException("El nombre tiene que tener menos de 31 caracteres");
        }
        if (entity.getRatioFuerzaMin() <= 0.2 || entity.getRatioFuerzaMin() > 0.6) {
            throw new IllegalOperationException("la fuerza debe estar entre 0.2 y 0.6");
        }
        if (entity.getNumeroStorm() <= 1000) {
            throw new IllegalOperationException("deben haber por lo menos 100 strormtroopers");
        }

        SistemaSolar guardado = sistemaSolarRepository.save(entity);


        return guardado;
    }
}

 