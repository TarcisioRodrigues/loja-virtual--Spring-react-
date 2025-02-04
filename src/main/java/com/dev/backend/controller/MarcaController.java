package com.dev.backend.controller;

import com.dev.backend.entity.Marca;
import com.dev.backend.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/marca")
public class MarcaController {
    @Autowired
    private MarcaService marcaService;
    @GetMapping("/")
    public List<Marca> list(){
        return marcaService.list();
    }
    @PostMapping("/create")
    public Marca create(@RequestBody Marca marca){
        return marcaService.create(marca);
    }
    @PutMapping("/update")
    public Marca update(@RequestBody Marca marca){
        return marcaService.update(marca);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        marcaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
