//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Experiencias;
import com.prueba.nacho.service.SExperiencias;
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
@RequestMapping("experiencia")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencias {
    @Autowired
    SExperiencias expeServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Experiencias> verExperiencias(){
    return expeServ.verExperiencias();
    }
    
     @PostMapping ("/nueva")
    public String agregarExperiencia  (@RequestBody Experiencias expe){ //se le pone un apodo a Persona
    expeServ.crearExperiencia(expe);
    return "La experiencia fue creada correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarExperiencia(@PathVariable Long id){
        expeServ.borrarExperiencia(id);
        return "La experiencia fue borrada correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Experiencias> buscarExperiencia(@PathVariable Long id) {
       if (!expeServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Experiencias expe = expeServ.getOne(id).get();
    return new ResponseEntity(expe, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public Experiencias EditarExperiencia(@PathVariable("id") Long id, @RequestBody Experiencias exper) {
			Experiencias _expe = expeServ.buscarExperiencia(id);
                        _expe.setPuesto(exper.getPuesto());
			_expe.setLugar(exper.getLugar());
                        _expe.setInicio(exper.getInicio());
                        _expe.setFin(exper.getFin());
                        			
                    
			expeServ.crearExperiencia(_expe);
                        return _expe;
		
	}    
    
}

