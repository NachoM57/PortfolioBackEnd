
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.HabilidadesDuras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRHabilidadesDuras extends JpaRepository<HabilidadesDuras, Long> {

}