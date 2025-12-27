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

    @Column(name = "EMAIL", nullable = true, length = 100, unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "DTCRIACAO", updatable = false)
    private LocalDateTime dtCriacao;

    @UpdateTimestamp
    @Column(name = "DTALTER")
    private LocalDateTime dtAlter;

    public ModelUsuarios() {}

    public ModelUsuarios(String nomeComp, String cpf, String email) {
        this.nomeComp = nomeComp;
        this.cpf = cpf;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public LocalDateTime getDtAlter() {
        return dtAlter;
    }
}
