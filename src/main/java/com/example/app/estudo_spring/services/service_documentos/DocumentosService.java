package com.example.app.estudo_spring.services.service_documentos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.estudo_spring.models.tb_documentos.ModelDocumentos;
import com.example.app.estudo_spring.repository.rp_documentos.RepoDocumentos;

@Service
public class DocumentosService {
    @Autowired
    private RepoDocumentos repoDocumentos;
    public String funcionando() {
        return "Serviço de Documentos funcionando!";
    }

    public List<ModelDocumentos> todosDocumentos() {
        return this.repoDocumentos.findAll();
    }
    public List<ModelDocumentos> procurarPorRg(String rg) {
        return this.repoDocumentos.findAll()
            .stream()
            .filter(d -> d.getRg().equals(rg))
            .toList();
    }

    public ModelDocumentos salvarDocumento(ModelDocumentos documento) {
        return this.repoDocumentos.save(documento);
    }


}
