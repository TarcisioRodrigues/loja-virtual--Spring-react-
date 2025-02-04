package com.dev.backend.controller;

import com.dev.backend.entity.Categoria;
import com.dev.backend.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    @GetMapping("/")
    public List<Categoria> list(){
        return categoriaService.list();
    }
    @PostMapping("/create")
    public Categoria create(@RequestBody Categoria categoria){
        return categoriaService.create(categoria);
    }
    @PutMapping("/update")
    public Categoria update(@RequestBody Categoria categoria){
        return categoriaService.update(categoria);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        categoriaService.delete(id);
        return ResponseEntity.ok().build();
    }
}

