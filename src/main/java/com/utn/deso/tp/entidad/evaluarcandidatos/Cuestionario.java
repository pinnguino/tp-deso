package com.utn.deso.tp.entidad.evaluarcandidatos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuestionario")
@Getter
@Setter
@NoArgsConstructor
public class Cuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Clave de ingreso aleatoria de 8 caracteres, letras y dígitos (CU025)
    private String claveIngreso;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private Integer cantidadAccesos;

    private Double puntajeObtenido;

    @Enumerated(EnumType.STRING)
    private TipoEstado estado;

    private LocalDateTime fechaCambioEstado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "evaluacion_id")
    private Evaluacion evaluacion;

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RespuestaCuestionario> respuestas = new ArrayList<>();

    @OneToMany(mappedBy = "cuestionario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ResultadoCompetencia> resultados = new ArrayList<>();
}
