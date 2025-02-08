package com.dev.backend.controller;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessaoClienteController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/create")
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }

}
