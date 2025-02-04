package com.dev.backend.services;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    public List<Pessoa> list(){
        return pessoaRepository.findAll();
    }
    public Pessoa create(Pessoa pessoa){
        pessoa.setCreated_at(new Date());
        Pessoa pessoaNovo= pessoaRepository.saveAndFlush(pessoa);
        return pessoaNovo;
    }

    public Pessoa update(Pessoa pessoa){
        pessoa.setUpdated_at(new Date());
        return pessoaRepository.saveAndFlush(pessoa);
    }


    public void delete(Long id){
        Pessoa pessoa= pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
