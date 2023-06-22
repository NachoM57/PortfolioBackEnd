
package com.prueba.nacho.repository;

import com.prueba.nacho.entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository <ContactForm, Long>{
    
}
