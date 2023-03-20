
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
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String nombre;
    @NotNull //para que no este en blanco el campo
    private String email;
   @Lob
    private String mensaje;

    public Email() {
    }

    public Email(Long id,  String nombre, String email, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;
    }
   
}
   
