package com.dev.backend.services;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public List<Categoria> list(){
        return categoriaRepository.findAll();
    }
    public Categoria create(Categoria categoria){
        categoria.setCreated_at(new Date());
        Categoria categoriaNovo= categoriaRepository.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria update(Categoria categoria){
        categoria.setUpdated_at(new Date());
        return categoriaRepository.saveAndFlush(categoria);
    }


    public void delete(Long id){
        Categoria categoria= categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
