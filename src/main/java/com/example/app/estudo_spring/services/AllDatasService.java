package com.example.app.estudo_spring.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;
import com.example.app.estudo_spring.repository.rp_usuarios.RepoUsuarios;

@Service
public class AllDatasService {

    @Autowired
    private RepoUsuarios repository;

    public List<ModelUsuarios> allUsers() {
        return this.repository.findAll();
    }
    public List<ModelUsuarios> procurarPorCpf(String cpf) {
        return this.repository.findAll()
            .stream()
            .filter(u -> u.getCPF().equals(cpf))
            .toList();
    }
}