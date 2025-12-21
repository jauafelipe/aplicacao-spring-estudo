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
    private Long idUser;

    @Column(name = "NOME_COMP", nullable = false, length = 150)
    private String nomeComp;

    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private String cpf;

    @CreationTimestamp
    @Column(name = "DTCRIACAO", updatable = false)
    private LocalDateTime dtCriacao;

    @UpdateTimestamp
    @Column(name = "DTALTER")
    private LocalDateTime dtAlter;

    public ModelUsuarios() {}

    public ModelUsuarios(String nomeComp, String cpf) {
        this.nomeComp = nomeComp;
        this.cpf = cpf;
    }

    // Getters e Setters
    public Long getIdUser() {
        return idUser;
    }

    public String getNomeComp() {
        return nomeComp;
    }

    public void setNomeComp(String nomeComp) {
        this.nomeComp = nomeComp;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public LocalDateTime getDtAlter() {
        return dtAlter;
    }
}
