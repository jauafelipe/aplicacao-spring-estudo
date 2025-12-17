package com.example.app.estudo_spring.repository.rp_usuarios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;

@Repository
public interface RepoUsuarios extends JpaRepository<ModelUsuarios,Long> {

    
}
