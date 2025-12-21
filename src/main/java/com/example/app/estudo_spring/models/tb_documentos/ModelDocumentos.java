package com.example.app.estudo_spring.models.tb_documentos;

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
@Table(name = "DOCUMENTOS")
public class ModelDocumentos {

    @Id
    @Column(name = "ID_DOC")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name ="FK_USER",
        referencedColumnName = "ID_USER",
        nullable = false
    )
    private ModelUsuarios fkUser;


    @Column(name = "RG", nullable = false, length = 150)
    private String rg;

    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private String cpf;
    
    @Column(name = "NUM_SUS", nullable = false, length = 15, unique = true)
    private String num_sus;




    public String getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public String getNum_sus() {
        return num_sus;
    }

 
}
