
package com.prueba.nacho.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
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
    private String link;
    @NotNull //para que no este en blanco el campo
   private String titulo;
    @Lob
    private String descripcion;
    private String inicio;
    private String fin;

    public Proyectos() {
    }

    public Proyectos(Long id, String imagen, String titulo, String link, String descripcion, String inicio, String fin) {
        this.id = id;
        this.imagen = imagen;
        this.titulo = titulo;
        this.link = link;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
    }



    








}