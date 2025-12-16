package com.example.app.estudo_spring.repository.rp_usuarios;


import org.springframework.data.repository.Repository;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;

public interface RepoUsuarios extends Repository<ModelUsuarios,Long> {
    ModelUsuarios findByIdUser(Long id);
    ModelUsuarios save(ModelUsuarios usuario);
    ModelUsuarios findByCpf(String cpf);
    
}
