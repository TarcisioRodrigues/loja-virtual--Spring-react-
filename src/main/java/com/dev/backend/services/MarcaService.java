package com.dev.backend.services;

import com.dev.backend.entity.Marca;
import com.dev.backend.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;
    public List<Marca> list(){
        return marcaRepository.findAll();
    }
    public Marca create(Marca marca){
        marca.setCreated_at(new Date());
        Marca marcaNovo= marcaRepository.saveAndFlush(marca);
        return marcaNovo;
    }

    public Marca update(Marca marca){
        marca.setUpdated_at(new Date());
        return marcaRepository.saveAndFlush(marca);
    }


    public void delete(Long id){
        Marca marca= marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
