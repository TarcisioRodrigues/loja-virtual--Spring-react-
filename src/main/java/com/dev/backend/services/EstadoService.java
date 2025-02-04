package com.dev.backend.services;

import com.dev.backend.entity.Estado;
import com.dev.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;
    public List<Estado> list(){
        return estadoRepository.findAll();
    }
     public Estado create(Estado estado){
        estado.setCreated_at(new Date());
            Estado estadoNovo=estadoRepository.saveAndFlush(estado);
            return estadoNovo;
     }

    public Estado update(Estado estado){
        estado.setUpdated_at(new Date());
        return estadoRepository.saveAndFlush(estado);
    }


    public void delete(Long id){
        Estado estado=estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }

}
