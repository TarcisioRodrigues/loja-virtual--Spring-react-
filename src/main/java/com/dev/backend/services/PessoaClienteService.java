package com.dev.backend.services;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PermissaoRepository;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaClienteService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa create(PessoaClienteRequestDTO pessoaClienteRequestDTO){
    Pessoa pessoa =new PessoaClienteRequestDTO().convert(pessoaClienteRequestDTO);
        pessoa.setCreated_at(new Date());
        Pessoa pessoaNovo= pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
        return pessoaNovo;
    }


}
