package com.example.app.estudo_spring.repository.rp_residencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.estudo_spring.models.tb_residencia.ModelResidecia;

public interface RepoResidencia extends JpaRepository<ModelResidecia, Long> {
    
}
