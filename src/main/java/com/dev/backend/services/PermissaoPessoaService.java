package com.dev.backend.services;

import com.dev.backend.entity.Permissao;
import com.dev.backend.entity.PermissaoPessoa;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoPessoaRepository;
import com.dev.backend.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;
    @Autowired
    private PermissaoRepository permissaoRepository;
    public void vincularPessoaPermissaoCliente(Pessoa pessoa){
        List <Permissao> listaPermissao=permissaoRepository.findByNome("cliente");

        if(listaPermissao.size()>0){
            PermissaoPessoa permissaoPessoa=new PermissaoPessoa();

            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setCreated_at(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }


    }



}
