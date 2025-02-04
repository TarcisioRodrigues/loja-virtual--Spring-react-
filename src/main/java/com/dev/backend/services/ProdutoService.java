package com.dev.backend.services;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    public List<Produto> list(){
        return produtoRepository.findAll();
    }
    public Produto create(Produto produto){
        produto.setCreated_at(new Date());
        Produto produtoNovo= produtoRepository.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto update(Produto produto){
        produto.setUpdated_at(new Date());
        return produtoRepository.saveAndFlush(produto);
    }


    public void delete(Long id){
        Produto produto= produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
