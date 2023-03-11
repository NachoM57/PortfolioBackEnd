//los metodos que se van a utilizar
package com.prueba.nacho.service;


import com.prueba.nacho.entity.Email;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.repository.IREmail;
import java.util.Optional;

@Service
@Transactional
public class SEmail {

    @Autowired
    IREmail reEmail; //llamo al repositorio


    public List<Email> verEmail() {
        List<Email> ListaEmail = reEmail.findAll();
        return ListaEmail;
    }

 
    public void crearEmail(Email email) {
        reEmail.save(email);
    }


    public void borrarEmail(Long id) {
        reEmail.deleteById(id);
    }

 
    public Email buscarEmail(Long id) {
        Email email = reEmail.findById(id).orElse(null);
        return email;

    }
    
    public Optional<Email> getOne(Long id){
         return reEmail.findById(id);
     }

      public boolean existsById(Long id){
         return reEmail.existsById(id);
     }
}

