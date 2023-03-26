
package com.prueba.nacho.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter @Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String imagenperfil;
   @Lob
    private String descripcion;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String imagenperfil, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagenperfil = imagenperfil;
        this.descripcion = descripcion;
    }



}
