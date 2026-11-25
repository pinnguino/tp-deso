package com.utn.deso.tp.entidad.puestos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "puesto")
@Getter
@Setter
@NoArgsConstructor
public class Puesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombrePuesto;

    private String codigo;

    private String descripcion;

    private Boolean eliminado = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    // Composición: el puesto se compone de sus competencias con ponderación requerida
    @OneToMany(mappedBy = "puesto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuestoCompetencia> competencias = new ArrayList<>();
}
