package com.dev.backend.controller;

import com.dev.backend.entity.Permissao;
import com.dev.backend.services.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
    @Autowired
    private PermissaoService permissaoService;
    @GetMapping("/")
    public List<Permissao> list(){
        return permissaoService.list();
    }
    @PostMapping("/create")
    public Permissao create(@RequestBody Permissao permissao){
        return permissaoService.create(permissao);
    }
    @PutMapping("/update")
    public Permissao update(@RequestBody Permissao permissao){
        return permissaoService.update(permissao);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        permissaoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
