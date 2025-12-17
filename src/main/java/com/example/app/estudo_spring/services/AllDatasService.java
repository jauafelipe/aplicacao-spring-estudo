package com.example.app.estudo_spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;
import com.example.app.estudo_spring.repository.rp_usuarios.RepoUsuarios;

@Service
public class AllDatasService {

    @Autowired
    private RepoUsuarios repository;

    public List<ModelUsuarios> index() {
        return repository.findAll();
    }
}