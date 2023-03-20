//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.HabilidadesBlandas;
import com.prueba.nacho.service.SHabilidadesBlandas;
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
@RequestMapping("habilidadblanda")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CHabilidadesBlandas {
    @Autowired
    SHabilidadesBlandas habilbServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <HabilidadesBlandas> verHabilidadesBlandas(){
    return habilbServ.verHabilidadesBlandas();
    }
    
     @PostMapping ("/nueva")
    public String agregarHabilidadBlanda  (@RequestBody HabilidadesBlandas habilb){ //se le pone un apodo a Persona
    habilbServ.crearHabilidadBlanda(habilb);
    return "La habilidad fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarHabilidadBlanda(@PathVariable Long id){
        habilbServ.borrarHabilidadBlanda(id);
        return "La habilidad fue borrada correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<HabilidadesBlandas> buscarHabilidadBlanda(@PathVariable Long id) {
       if (!habilbServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    HabilidadesBlandas habilb = habilbServ.getOne(id).get();
    return new ResponseEntity(habilb, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public HabilidadesBlandas EditarPersona(@PathVariable("id") Long id, @RequestBody HabilidadesBlandas habib) {
			HabilidadesBlandas _habilb = habilbServ.buscarHabilidadesBlandas(id);
                        _habilb.setImagen(habib.getImagen());
			_habilb.setTitulo(habib.getTitulo());
                        _habilb.setDescripcion(habib.getDescripcion());
                        
                     
                        			
                    
			habilbServ.crearHabilidadBlanda(_habilb);
                        return _habilb;
		
	}    
    
}

