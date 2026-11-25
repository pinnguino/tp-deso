package com.utn.deso.tp.entidad.evaluarcandidatos;

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
@Table(name = "respuesta_cuestionario")
@Getter
@Setter
@NoArgsConstructor
public class RespuestaCuestionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroBloque;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cuestionario_id")
    private Cuestionario cuestionario;
}
