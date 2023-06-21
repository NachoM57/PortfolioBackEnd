
package com.prueba.nacho.controller;

import com.prueba.nacho.entity.ContactForm;
import com.prueba.nacho.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 @RestController
@RequestMapping("contacto")
 @CrossOrigin(origins = {"https://frontend-argentina-progr-6523c.web.app", "http://localhost:4200"})
public class ContactController {
  @Autowired
  private EmailService emailService;
  private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);


 @PostMapping(value = "/email")
public ResponseEntity<Object> enviarEmail(@RequestBody ContactForm email){
  try {
    emailService.sendEmail(email);
    return new ResponseEntity<>(email, HttpStatus.OK);
  } catch(Exception e){
    LOGGER.error("Error al enviar el email", e);
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
}