package com.dev.backend.controller;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.services.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoa-cliente")
public class PessoaGerenciamentoController {
    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/")
    public String recuperarCodigo(@RequestParam("email") String email) {
        return pessoaGerenciamentoService.solicitarCodigo(email);
    }

}
