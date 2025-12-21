package com.example.app.estudo_spring.repository.rp_documentos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app.estudo_spring.models.tb_documentos.ModelDocumentos;

public interface RepoDocumentos extends JpaRepository<ModelDocumentos, Long> {
    
}
