package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.RegionType;
import co.edu.uniandes.dse.ParcialPractico1_202520.entities.SistemaSolar;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
@Transactional
class SistemaSolarServiceTest {

    @Autowired
    private SistemaSolarService sistemaSolarService;

    private final PodamFactory factory = new PodamFactoryImpl();

    @Test
    void createSistemaSolar_BIEN() throws IllegalOperationException {
        SistemaSolar s = factory.manufacturePojo(SistemaSolar.class);
        s.setNombre("Planet");            
        s.setRegion(RegionType.CORE);
        s.setRatioFuerzaMin(0.4);      
        s.setNumeroStorm(5000L);  

        SistemaSolar saved = sistemaSolarService.createSistemaSolar(s);
        assertNotNull(saved.getId());
    }

}
