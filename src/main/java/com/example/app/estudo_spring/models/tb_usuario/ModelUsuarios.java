package com.example.app.estudo_spring.models.tb_usuario;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "USUARIOS")
public class ModelUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long ID_USER;

    @Column(name = "NOME_COMP")
    private String NOME_COMP;

    @Column(name = "CPF")
    private String CPF;

    @CreationTimestamp
    @Column(name = "DTCRIACAO")
    private LocalDateTime DTCRIACAO;

    @UpdateTimestamp
    @Column(name = "DTALTER")
    private LocalDateTime DTALTER;

    public ModelUsuarios() {
    }

    public ModelUsuarios(String nome, String cpf) {
        this.NOME_COMP = nome;
        this.CPF = cpf;
    }

    public Long getID_USER() {
        return ID_USER;
    }

    public String getNOME_COMP() {
        return NOME_COMP;
    }

    public String getCPF() {
        return CPF;
    }

    public LocalDateTime getDTCRIACAO() {
        return DTCRIACAO;
    }

    public LocalDateTime getDTALTER() {
        return DTALTER;
    }
}
