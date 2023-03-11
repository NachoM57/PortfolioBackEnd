
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IREmail extends JpaRepository<Email, Long> {

}
