
package com.prueba.nacho.entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String puesto;
    @NotNull //para que no este en blanco el campo
    private String lugar;
    private String inicio;
    private String fin;

    public Experiencias() {
    }

    public Experiencias(Long id, String puesto, String lugar, String inicio, String fin) {
        this.id = id;
        this.puesto = puesto;
        this.lugar = lugar;
        this.inicio = inicio;
        this.fin = fin;
    }

    
    
}