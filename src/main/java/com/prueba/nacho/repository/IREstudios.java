
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IREstudios extends JpaRepository<Estudios, Long> {

}