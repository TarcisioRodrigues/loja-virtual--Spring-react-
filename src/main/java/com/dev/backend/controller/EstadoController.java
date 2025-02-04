package com.dev.backend.controller;

import com.dev.backend.entity.Estado;
import com.dev.backend.services.EstadoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;
    @GetMapping("/")
    public List<Estado> list(){
        return estadoService.list();
    }
    @PostMapping("/create")
    public Estado create(@RequestBody Estado estado){
        return estadoService.create(estado);
    }
    @PutMapping("/update")
    public Estado update(@RequestBody Estado estado){
        return estadoService.update(estado);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete( @PathVariable("id") Long id){
        estadoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
