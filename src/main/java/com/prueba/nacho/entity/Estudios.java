
package com.prueba.nacho.entity;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String estudio;
    @NotNull //para que no este en blanco el campo
    private String lugar;
    private String inicio;
    private String fin;
   @Lob
    private String descripcion;

    public Estudios() {
    }

    public Estudios(Long id, String estudio, String lugar, String inicio, String fin, String descripcion) {
        this.id = id;
        this.estudio = estudio;
        this.lugar = lugar;
        this.inicio = inicio;
        this.fin = fin;
        this.descripcion = descripcion;
    }





}
