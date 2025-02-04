package com.dev.backend.services;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    public List<Cidade> list(){
        return cidadeRepository.findAll();
    }
     public Cidade create(Cidade cidade){
        cidade.setCreated_at(new Date());
            Cidade cidadeNovo= cidadeRepository.saveAndFlush(cidade);
            return cidadeNovo;
     }

    public Cidade update(Cidade cidade){
        cidade.setUpdated_at(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }


    public void delete(Long id){
        Cidade cidade= cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }

}
