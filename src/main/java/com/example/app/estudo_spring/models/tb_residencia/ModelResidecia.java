package com.example.app.estudo_spring.models.tb_residencia;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESIDENCIA")
public class ModelResidecia {
    @Id
    @Column(name = "ID_RESIDENCIA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResidencia;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name ="FK_USU",
        referencedColumnName = "ID_USER",
        nullable = false
    )
    private ModelUsuarios fkUsu;
    @Column(name = "ENDERECO", nullable = false, length = 150)
    private String endereco;
    @Column(name = "CIDADE", nullable = false, length = 100)
    private String cidade;
    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;
    @Column(name = "CEP", nullable = false, length = 8)
    private String cep;
    @Column(name = "NUMERO", nullable = false, length = 10)
    private String numero;

    public String getEndereco() {
        return endereco;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getCep() {
        return cep;
    }
    public String getNumero() {
        return numero;
    }
}
