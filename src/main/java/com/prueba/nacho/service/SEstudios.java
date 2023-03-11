//los metodos que se van a utilizar
package com.prueba.nacho.service;


import com.prueba.nacho.entity.Estudios;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.repository.IREstudios;
import java.util.Optional;

@Service
@Transactional
public class SEstudios {

    @Autowired
    IREstudios reEstud; //llamo al repositorio


    public List<Estudios> verEstudios() {
        List<Estudios> ListaEstudios = reEstud.findAll();
        return ListaEstudios;
    }

 
    public void crearEstudio(Estudios estud) {
        reEstud.save(estud);
    }


    public void borrarEstudio(Long id) {
        reEstud.deleteById(id);
    }

 
    public Estudios buscarEstudio(Long id) {
        Estudios estud = reEstud.findById(id).orElse(null);
        return estud;

    }
    
    public Optional<Estudios> getOne(Long id){
         return reEstud.findById(id);
     }

      public boolean existsById(Long id){
         return reEstud.existsById(id);
     }
}
