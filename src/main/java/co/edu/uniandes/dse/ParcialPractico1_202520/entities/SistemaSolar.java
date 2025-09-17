package co.edu.uniandes.dse.ParcialPractico1_202520.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class SistemaSolar extends BaseEntity {

    private String nombre;

    @Enumerated(EnumType.STRING)
    private RegionType region;
    private Double ratioFuerzaMin;
    private Long numeroStorm;

    @OneToMany(mappedBy = "sistemasolar")
    private List<PlanetaEntity> planetas = new ArrayList<>();
}
