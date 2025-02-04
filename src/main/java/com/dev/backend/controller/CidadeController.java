package com.dev.backend.controller;

import com.dev.backend.entity.Cidade;


import com.dev.backend.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;
    @GetMapping("/")
    public List<Cidade> list(){
        return cidadeService.list();
    }
    @PostMapping("/create")
    public Cidade create(@RequestBody Cidade cidade){
        return cidadeService.create(cidade);
    }
    @PutMapping("/update")
    public Cidade update(@RequestBody Cidade cidade){
        return cidadeService.update(cidade);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete( @PathVariable("id") Long id){
        cidadeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
