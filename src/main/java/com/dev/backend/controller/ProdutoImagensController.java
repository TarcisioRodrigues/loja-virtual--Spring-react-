package com.dev.backend.controller;

import com.dev.backend.entity.Categoria;
import com.dev.backend.entity.ProdutosImagens;
import com.dev.backend.services.ProdutoImagensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/api/produtoImagens")
public class ProdutoImagensController {

    @Autowired
    private ProdutoImagensService produtoImagensService;
    @GetMapping("/")
    public List<ProdutosImagens> list(){
        return produtoImagensService.list();
    }
    @PostMapping("/create")
    public ProdutosImagens create(@RequestParam("idProduto") Long id,@RequestParam("file")MultipartFile file){
        return produtoImagensService.create(id,file);
    }
    @PutMapping("/update")
    public ProdutosImagens update(@RequestBody ProdutosImagens produtosImagens){
        return produtoImagensService.update(produtosImagens);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        produtoImagensService.delete(id);
        return ResponseEntity.ok().build();
    }
}
