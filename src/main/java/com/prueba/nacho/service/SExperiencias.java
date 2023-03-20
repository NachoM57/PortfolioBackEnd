//los metodos que se van a utilizar
package com.prueba.nacho.service;

import com.prueba.nacho.entity.Experiencias;
import com.prueba.nacho.repository.IRExperiencias;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class SExperiencias {

    @Autowired
    IRExperiencias reExpe; //llamo al repositorio


    public List<Experiencias> verExperiencias() {
        List<Experiencias> ListaExperiencias = reExpe.findAll();
        return ListaExperiencias;
    }

 
    public void crearExperiencia(Experiencias expe) {
        reExpe.save(expe);
    }


    public void borrarExperiencia(Long id) {
        reExpe.deleteById(id);
    }

 
    public Experiencias buscarExperiencia(Long id) {
        Experiencias expe = reExpe.findById(id).orElse(null);
        return expe;

    }
    
    public Optional<Experiencias> getOne(Long id){
         return reExpe.findById(id);
     }

      public boolean existsById(Long id){
         return reExpe.existsById(id);
     }
}


