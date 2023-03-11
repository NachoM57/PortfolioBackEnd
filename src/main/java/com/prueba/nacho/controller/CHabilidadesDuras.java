//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.HabilidadesDuras;
import com.prueba.nacho.service.SHabilidadesDuras;
import java.util.List;
import javax.transaction.Transactional;
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
@RequestMapping("habilidaddura")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidadesDuras {
    @Autowired
    SHabilidadesDuras habildServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <HabilidadesDuras> verHabilidadesDuras(){
    return habildServ.verHabilidadesDuras();
    }
    
     @PostMapping ("/nueva")
    public String agregarHabilidadDura  (@RequestBody HabilidadesDuras habild){ //se le pone un apodo a Persona
    habildServ.crearHabilidadDura(habild);
    return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarHabilidadDura(@PathVariable Long id){
        habildServ.borrarHabilidadDura(id);
        return "La habildad fue borrada correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<HabilidadesDuras> buscarHabilidadDura(@PathVariable Long id) {
       if (!habildServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    HabilidadesDuras habild = habildServ.getOne(id).get();
    return new ResponseEntity(habild, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public HabilidadesDuras EditarHabildadDura(@PathVariable("id") Long id, @RequestBody HabilidadesDuras habd) {
			HabilidadesDuras _habild = habildServ.buscarHabilidadDura(id);
                        _habild.setHabilidad(habd.getHabilidad());
			_habild.setPorcentaje(habd.getPorcentaje());
                     
                        			
                    
			habildServ.crearHabilidadDura(_habild);
                        return _habild;
		
	}    
    
}

