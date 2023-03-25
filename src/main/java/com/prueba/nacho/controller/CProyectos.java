
//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Proyectos;
import com.prueba.nacho.service.SProyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("proyecto")
@Transactional
@CrossOrigin(origins = "https://frontend-argentina-progr-6523c.web.app")
public class CProyectos {
    @Autowired
    SProyectos proyecServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Proyectos> verProyectos(){
    return proyecServ.verProyectos();
    }
    
     @PostMapping ("/nueva")
    public String agregarProyecto  (@RequestBody Proyectos proyec){ //se le pone un apodo a Persona
    proyecServ.crearProyecto(proyec);
    return "El proyecto fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarProyecto(@PathVariable Long id){
        proyecServ.borrarProyecto(id);
        return "El proyecto fue borrado correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Proyectos> buscarProyecto(@PathVariable Long id) {
       if (!proyecServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Proyectos proyec = proyecServ.getOne(id).get();
    return new ResponseEntity(proyec, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public Proyectos EditarProyecto(@PathVariable("id") Long id, @RequestBody Proyectos proy) {
			Proyectos _proyec = proyecServ.buscarProyecto(id);
                        _proyec.setImagen(proy.getImagen());
			_proyec.setTitulo(proy.getTitulo());
                        _proyec.setDescripcion(proy.getDescripcion());
                        _proyec.setInicio(proy.getInicio());
                        _proyec.setFin(proy.getFin());
                        			
                    
			proyecServ.crearProyecto(_proyec);
                        return _proyec;
		
	}    
    
}
