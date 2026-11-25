package com.utn.deso.tp.entidad.puestos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puesto_competencia")
@Getter
@Setter
@NoArgsConstructor
public class PuestoCompetencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double ponderacionRequerida;

    @ManyToOne(optional = false)
    @JoinColumn(name = "puesto_id")
    private Puesto puesto;
}
