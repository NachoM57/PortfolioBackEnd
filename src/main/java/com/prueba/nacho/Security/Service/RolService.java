
package com.prueba.nacho.Security.Service;

import com.prueba.nacho.Security.Entity.Rol;
import com.prueba.nacho.Security.Enums.RolNombre;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.nacho.Security.Repository.iRolRepository;

@Service
@Transactional
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
