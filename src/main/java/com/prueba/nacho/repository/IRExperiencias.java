
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Experiencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRExperiencias extends JpaRepository<Experiencias, Long> {

}