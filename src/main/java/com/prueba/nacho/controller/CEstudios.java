//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Estudios;
import com.prueba.nacho.service.SEstudios;
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
@RequestMapping("estudio")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CEstudios {
    @Autowired
    SEstudios estuServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Estudios> verEstudios(){
    return estuServ.verEstudios();
    }
    
     @PostMapping ("/nueva")
    public String agregarEstudio  (@RequestBody Estudios est){ //se le pone un apodo a Persona
    estuServ.crearEstudio(est);
    return "El estudio fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarEstudio(@PathVariable Long id){
        estuServ.borrarEstudio(id);
        return "El estudio fue borrada correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Estudios> buscarEstudio(@PathVariable Long id) {
       if (!estuServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Estudios est = estuServ.getOne(id).get();
    return new ResponseEntity(est, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public Estudios EditarEstudio(@PathVariable("id") Long id, @RequestBody Estudios estudd) {
			Estudios _est = estuServ.buscarEstudio(id);
                        _est.setEstudio(estudd.getEstudio());
			_est.setLugar(estudd.getLugar());
                        _est.setInicio(estudd.getInicio());
                        _est.setFin(estudd.getFin());
                        _est.setDescripcion(estudd.getDescripcion());	
                    
			estuServ.crearEstudio(_est);
                        return _est;
		
	}    
    
}
