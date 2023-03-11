
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.HabilidadesBlandas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRHabilidadesBlandas extends JpaRepository<HabilidadesBlandas, Long> {

}