//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Email;
import com.prueba.nacho.service.SEmail;
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
@RequestMapping("email")
@Transactional
@CrossOrigin(origins = "https://frontend-argentina-progr-6523c.web.app")
public class CEmail {
    @Autowired
    SEmail emailServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Email> verEmail(){
    return emailServ.verEmail();
    }
    
     @PostMapping ("/nueva")
    public String agregarEmail  (@RequestBody Email emaill){ //se le pone un apodo a Persona
    emailServ.crearEmail(emaill);
    return "El Email fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarEmail(@PathVariable Long id){
        emailServ.borrarEmail(id);
        return "El Email fue borrado correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Email> buscarEmail(@PathVariable Long id) {
       if (!emailServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Email email = emailServ.getOne(id).get();
    return new ResponseEntity(email, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public Email EditarEmail(@PathVariable("id") Long id, @RequestBody Email emai) {
			Email _email = emailServ.buscarEmail(id);
                        _email.setNombre(emai.getNombre());
			_email.setEmail(emai.getEmail());
                        _email.setMensaje(emai.getMensaje());
                        
                        			
                    
			emailServ.crearEmail(_email);
                        return _email;
		
	}    
    
    

}
