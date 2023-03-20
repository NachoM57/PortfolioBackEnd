//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Persona;
import com.prueba.nacho.service.SPersona;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("persona")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CPersona {
    @Autowired
    SPersona persoServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Persona> verPersonas(){
    return persoServ.verPersonas();
    }
    @PreAuthorize("hasRole('ADMIN')")
     @PostMapping ("/nueva")
    public String agregarPersona  (@RequestBody Persona pers){ //se le pone un apodo a Persona
    persoServ.crearPersona(pers);
    return "La persona fue creada correctamente";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/borrar/{id}")
    public String eliminarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
        return "La persona fue borrada correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable Long id) {
       if (!persoServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Persona pers = persoServ.getOne(id).get();
    return new ResponseEntity(pers, HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/editar/{id}")
    public Persona EditarPersona(@PathVariable("id") Long id, @RequestBody Persona perso) {
			Persona _pers = persoServ.buscarPersona(id);
                        _pers.setImagenperfil(perso.getImagenperfil());
			_pers.setDescripcion(perso.getDescripcion());
                        _pers.setNombre(perso.getNombre());
                        _pers.setApellido(perso.getApellido());
                        			
                    
			persoServ.crearPersona(_pers);
                        return _pers;
		
	}    
    
    

}
