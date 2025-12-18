package com.example.app.estudo_spring.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.estudo_spring.services.AllDatasService;
import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;



@RestController
@RequestMapping("/usuarios")
public class DataController {

    @Autowired
    private AllDatasService allDatasService;
    
    @GetMapping
    public String ping() {
        return "Api V1 online!";
    }

    @GetMapping("/all-users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModelUsuarios> allDatas() {
        System.out.println("Entrou no controller");
        return this.allDatasService.allUsers();
    }
   
    @GetMapping("/procurar-cpf/{cpf}")
    public List<ModelUsuarios> procurarPorCpf(@PathVariable String cpf) {
        return this.allDatasService.procurarPorCpf(cpf);
    }
}
