//los metodos que se van a utilizar
package com.prueba.nacho.service;


import com.prueba.nacho.entity.Proyectos;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.repository.IRProyectos;
import java.util.Optional;

@Service
@Transactional
public class SProyectos {

    @Autowired
    IRProyectos reProyecto; //llamo al repositorio


    public List<Proyectos> verProyectos() {
        List<Proyectos> ListaProyectos = reProyecto.findAll();
        return ListaProyectos;
    }

 
    public void crearProyecto(Proyectos proy) {
        reProyecto.save(proy);
    }


    public void borrarProyecto(Long id) {
        reProyecto.deleteById(id);
    }

 
    public Proyectos buscarProyecto(Long id) {
        Proyectos proyec = reProyecto.findById(id).orElse(null);
        return proyec;

    }
    
    public Optional<Proyectos> getOne(Long id){
         return reProyecto.findById(id);
     }

      public boolean existsById(Long id){
         return reProyecto.existsById(id);
     }
}


