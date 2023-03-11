
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
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String imagen;
    @NotNull //para que no este en blanco el campo
   private String titulo;
    @Lob
    private String descripcion;
    private String inicio;
    private String fin;

    public Proyectos() {
    }

    public Proyectos(Long id, String imagen, String titulo, String descripcion, String inicio, String fin) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }


    








}