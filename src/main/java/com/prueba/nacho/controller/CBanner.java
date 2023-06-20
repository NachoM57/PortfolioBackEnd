//como se van a utilizar los metodos del servicio
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.Banner;
import com.prueba.nacho.service.SBanner;
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
@RequestMapping("banner")
@Transactional
@CrossOrigin(origins = {"https://frontend-argentina-progr-6523c.web.app", "http://localhost:4200"})
public class CBanner {
    @Autowired
    SBanner bannerServ; //importamos el servicio con un apodo
    
    @GetMapping("/ver")
    @ResponseBody
    public List <Banner> verBanner(){
    return bannerServ.verBanner();
    }
    
     @PostMapping ("/nueva")
    public String agregarBanner  (@RequestBody Banner bann){ //se le pone un apodo a Persona
    bannerServ.crearBanner(bann);
    return "El Banner fue creado correctamente";
    }
    
    @DeleteMapping ("/borrar/{id}")
    public String eliminarBanner(@PathVariable Long id){
        bannerServ.borrarBanner(id);
        return "El Banner fue borrado correctamente";
    }
    
         @GetMapping("/buscar/{id}")
    public ResponseEntity<Banner> buscarBanner(@PathVariable Long id) {
       if (!bannerServ.existsById(id)){
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
       }
    Banner bann = bannerServ.getOne(id).get();
    return new ResponseEntity(bann, HttpStatus.OK);
    }

     @PutMapping("/editar/{id}")
    public Banner EditarBanner(@PathVariable("id") Long id, @RequestBody Banner ban) {
			Banner _bann = bannerServ.buscarBanner(id);
                        _bann.setImagenbanner(ban.getImagenbanner());
			_bann.setNombrebanner(ban.getNombrebanner());
                        _bann.setTitulobanner(ban.getTitulobanner());
                        
                        			
                    
			bannerServ.crearBanner(_bann);
                        return _bann;
		
	}    
    
}
