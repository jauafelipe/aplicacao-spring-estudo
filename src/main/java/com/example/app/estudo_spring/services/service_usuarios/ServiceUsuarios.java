package com.example.app.estudo_spring.services.service_usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;
import com.example.app.estudo_spring.repository.rp_usuarios.RepoUsuarios;

@Service
public class ServiceUsuarios {
    @Autowired
    private RepoUsuarios repository;

    public List<ModelUsuarios> allUsers() {
        return this.repository.findAll();
    }
    public List<ModelUsuarios> procurarPorCpf(String cpf) {
        return this.repository.findAll()
            .stream()
            .filter(u -> u.getCpf().equals(cpf))
            .toList();
    }
    public List<ModelUsuarios> procurarPorEmail(String email) {
        return this.repository.findAll()
            .stream()
            .filter(u -> u.getEmail() != null && u.getEmail().equals(email))
            .toList();
    }
    public ModelUsuarios salvarUsuario(ModelUsuarios usuario) {
        return this.repository.save(usuario);
    }
}