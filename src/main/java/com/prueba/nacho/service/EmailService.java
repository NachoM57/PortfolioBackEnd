
package com.prueba.nacho.service;

import com.prueba.nacho.entity.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
     private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(ContactForm email) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("ignaciomaiorino50@gmail.com");
        mail.setFrom(email.getEmail());
        mail.setSubject("Contacto de " + email.getName() + " (" + email.getEmail() + ")");
        mail.setText(email.getMessage());

        javaMailSender.send(mail);
    }
}