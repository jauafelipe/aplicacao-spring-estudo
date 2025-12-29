package com.example.app.estudo_spring.controllers.controller_documento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.autoconfigure.metrics.DataMetricsProperties.Repository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.estudo_spring.models.tb_documentos.ModelDocumentos;
import com.example.app.estudo_spring.services.service_documentos.DocumentosService;

@RestController("/documentos")
public class DocumentosController {
    @Autowired
    private DocumentosService documentosService;



    @GetMapping("/ping")
    public String ping() {
        return this.documentosService.funcionando();
    }

    @GetMapping("/documentos-usuario")
    public ResponseEntity<List<ModelDocumentos>> documentosUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(this.documentosService.todosDocumentos());
    }
    
}
