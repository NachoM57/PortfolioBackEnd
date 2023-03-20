
package com.prueba.nacho.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter @Setter
public class HabilidadesDuras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String habilidad;
    @NotNull //para que no este en blanco el campo
    private int porcentaje;

    public HabilidadesDuras() {
    }

    public HabilidadesDuras(Long id, String habilidad, int porcentaje) {
        this.id = id;
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

  





}

