//los metodos que se van a utilizar
package com.prueba.nacho.service;

import com.prueba.nacho.entity.Persona;
import com.prueba.nacho.repository.IRPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class SPersona {

    @Autowired
    IRPersona rePersona; //llamo al repositorio


    public List<Persona> verPersonas() {
        List<Persona> ListaPersonas = rePersona.findAll();
        return ListaPersonas;
    }

 
    public void crearPersona(Persona per) {
        rePersona.save(per);
    }


    public void borrarPersona(Long id) {
        rePersona.deleteById(id);
    }

 
    public Persona buscarPersona(Long id) {
        Persona perso = rePersona.findById(id).orElse(null);
        return perso;

    }
    
    public Optional<Persona> getOne(Long id){
         return rePersona.findById(id);
     }

      public boolean existsById(Long id){
         return rePersona.existsById(id);
     }
}


