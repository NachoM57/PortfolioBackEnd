//los metodos que se van a utilizar
package com.prueba.nacho.service;


import com.prueba.nacho.entity.HabilidadesBlandas;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.repository.IRHabilidadesBlandas;
import java.util.Optional;

@Service
@Transactional
public class SHabilidadesBlandas {

    @Autowired
    IRHabilidadesBlandas reHabilidadb; //llamo al repositorio


    public List<HabilidadesBlandas> verHabilidadesBlandas() {
        List<HabilidadesBlandas> ListaHabilidadesBlandas = reHabilidadb.findAll();
        return ListaHabilidadesBlandas;
    }

 
    public void crearHabilidadBlanda(HabilidadesBlandas habilb) {
        reHabilidadb.save(habilb);
    }


    public void borrarHabilidadBlanda(Long id) {
        reHabilidadb.deleteById(id);
    }

 
    public HabilidadesBlandas buscarHabilidadesBlandas(Long id) {
        HabilidadesBlandas habilb = reHabilidadb.findById(id).orElse(null);
        return habilb;

    }
    
    public Optional<HabilidadesBlandas> getOne(Long id){
         return reHabilidadb.findById(id);
     }

      public boolean existsById(Long id){
         return reHabilidadb.existsById(id);
     }
}



