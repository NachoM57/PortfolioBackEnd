//los metodos que se van a utilizar
package com.prueba.nacho.service;

import com.prueba.nacho.entity.HabilidadesDuras;
import com.prueba.nacho.repository.IRHabilidadesDuras;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
@Transactional
public class SHabilidadesDuras {

    @Autowired
    IRHabilidadesDuras reHabilidadd; //llamo al repositorio


    public List<HabilidadesDuras> verHabilidadesDuras() {
        List<HabilidadesDuras> ListaHabilidadesDuras = reHabilidadd.findAll();
        return ListaHabilidadesDuras;
    }

 
    public void crearHabilidadDura(HabilidadesDuras habd) {
        reHabilidadd.save(habd);
    }


    public void borrarHabilidadDura(Long id) {
        reHabilidadd.deleteById(id);
    }

 
    public HabilidadesDuras buscarHabilidadDura(Long id) {
        HabilidadesDuras habid = reHabilidadd.findById(id).orElse(null);
        return habid;

    }
    
    public Optional<HabilidadesDuras> getOne(Long id){
         return reHabilidadd.findById(id);
     }

      public boolean existsById(Long id){
         return reHabilidadd.existsById(id);
     }
}

