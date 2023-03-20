
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
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull //para que no este en blanco el campo
    private String imagenbanner;
    @NotNull //para que no este en blanco el campo
    private String nombrebanner;
    private String titulobanner;

    public Banner() {
    }

    public Banner(Long id, String imagenbanner, String nombrebanner, String titulobanner) {
        this.id = id;
        this.imagenbanner = imagenbanner;
        this.nombrebanner = nombrebanner;
        this.titulobanner = titulobanner;
    }






}
