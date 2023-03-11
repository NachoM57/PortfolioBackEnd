
package com.prueba.nacho.repository;


import com.prueba.nacho.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRBanner extends JpaRepository<Banner, Long> {

}

