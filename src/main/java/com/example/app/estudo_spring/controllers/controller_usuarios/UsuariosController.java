package com.example.app.estudo_spring.controllers.controller_usuarios;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.estudo_spring.models.tb_usuario.ModelUsuarios;
import com.example.app.estudo_spring.services.service_envioEmail.RecordEmail;
import com.example.app.estudo_spring.services.service_envioEmail.ServiceSendEmail;
import com.example.app.estudo_spring.services.service_usuarios.ServiceUsuarios;



@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private ServiceUsuarios allDatasService;
    @Autowired
    private ServiceSendEmail emailService;
    
    @GetMapping
    public String ping() {
        return "Api V1 online!";
    }

    @GetMapping("/all-users")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModelUsuarios> allDatas() {
        return this.allDatasService.allUsers();
    }
   
    @GetMapping("/procurar-cpf/{cpf}")
    public List<ModelUsuarios> procurarPorCpf(@PathVariable String cpf) {
        return this.allDatasService.procurarPorCpf(cpf);
    }
    @GetMapping("/procurar-email/{email}")
    public ResponseEntity<List<ModelUsuarios>> procurarPorEmail(@PathVariable String email) {
        if(email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ModelUsuarios> resultados = this.allDatasService.procurarPorEmail(email);

        return ResponseEntity.ok(resultados);
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<ModelUsuarios> criarUsuario(
        @RequestBody ModelUsuarios novoUsuario
    ) {
        if(novoUsuario.getNomeComp() == null || novoUsuario.getNomeComp().isEmpty() ||
           novoUsuario.getCpf() == null || novoUsuario.getCpf().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if(novoUsuario.getEmail() != null && !novoUsuario.getEmail().isEmpty()) {
            var emailRecord = new RecordEmail(
                novoUsuario.getEmail(),
                "Bem-vindo ao sistema",
                "Olá " + novoUsuario.getNomeComp() + ", seu usuário foi criado com sucesso!"
            );
            emailService.sendMail(emailRecord);
        }
        ModelUsuarios usuarioSalvo = this.allDatasService.salvarUsuario(
            new ModelUsuarios(novoUsuario.getNomeComp(), novoUsuario.getCpf(), novoUsuario.getEmail())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }
}
