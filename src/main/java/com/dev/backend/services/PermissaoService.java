package com.dev.backend.services;

import com.dev.backend.entity.Marca;
import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;
    public List<Permissao> list(){
        return permissaoRepository.findAll();
    }
    public Permissao create(Permissao permissao){
        permissao.setCreated_at(new Date());
        Permissao permissaoNovo= permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    public Permissao update(Permissao permissao){
        permissao.setUpdated_at(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }


    public void delete(Long id){
        Permissao permissao= permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }


}
