
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRProyectos extends JpaRepository<Proyectos, Long> {

}
