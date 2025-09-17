package co.edu.uniandes.dse.ParcialPractico1_202520.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.ParcialPractico1_202520.entities.PlanetaEntity;
import co.edu.uniandes.dse.ParcialPractico1_202520.exceptions.IllegalOperationException;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
@Transactional
class PlanetaServiceTest {

    @Autowired
    private PlanetaService planetaService;

    private final PodamFactory factory = new PodamFactoryImpl();

    @Test
    void createPlaneta_BIEN() throws IllegalOperationException {
        PlanetaEntity planeta = factory.manufacturePojo(PlanetaEntity.class);
        planeta.setNombre("LittleBigPlanetII");   
        planeta.setPoblacion(123456L);     

        PlanetaEntity saved = planetaService.createPlaneta(planeta);
        assertNotNull(saved.getId());
    }

    @Test
    void createPlaneta_MAL() {
        PlanetaEntity planeta = factory.manufacturePojo(PlanetaEntity.class);
        planeta.setNombre("LittleBigPlanet2");  
        planeta.setPoblacion(10000L);

        assertThrows(IllegalOperationException.class, () -> planetaService.createPlaneta(planeta));
    }
}
