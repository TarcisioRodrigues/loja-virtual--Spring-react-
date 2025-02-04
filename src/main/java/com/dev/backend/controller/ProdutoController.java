package com.dev.backend.controller;

import com.dev.backend.entity.Produto;
import com.dev.backend.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping("/")
    public List<Produto> list(){
        return produtoService.list();
    }
    @PostMapping("/create")
    public Produto create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }
    @PutMapping("/update")
    public Produto update(@RequestBody Produto produto){
        return produtoService.update(produto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
