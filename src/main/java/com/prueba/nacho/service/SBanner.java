//los metodos que se van a utilizar
package com.prueba.nacho.service;


import com.prueba.nacho.entity.Banner;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.repository.IRBanner;
import java.util.Optional;

@Service
@Transactional
public class SBanner {

    @Autowired
    IRBanner reBanner; //llamo al repositorio


    public List<Banner> verBanner() {
        List<Banner> ListaBanner = reBanner.findAll();
        return ListaBanner;
    }

 
    public void crearBanner(Banner bann) {
        reBanner.save(bann);
    }


    public void borrarBanner(Long id) {
        reBanner.deleteById(id);
    }

 
    public Banner buscarBanner(Long id) {
        Banner ban = reBanner.findById(id).orElse(null);
        return ban;

    }
    
    public Optional<Banner> getOne(Long id){
         return reBanner.findById(id);
     }

      public boolean existsById(Long id){
         return reBanner.existsById(id);
     }
}
