package com.dev.backend.controller;

import com.dev.backend.entity.Estado;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;
    @GetMapping("/")
    public List<Pessoa> list(){
        return pessoaService.list();
    }
    @PostMapping("/create")
    public Pessoa create(@RequestBody Pessoa pessoa){
        return pessoaService.create(pessoa);
    }
    @PutMapping("/update")
    public Pessoa update(@RequestBody Pessoa pessoa){
        return pessoaService.update(pessoa);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
