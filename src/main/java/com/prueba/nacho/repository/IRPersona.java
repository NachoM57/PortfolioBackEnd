
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRPersona extends JpaRepository<Persona, Long> {

}
