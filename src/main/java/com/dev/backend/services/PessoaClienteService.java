package com.dev.backend.services;

import com.dev.backend.dto.PessoaClienteRequestDTO;
import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PessoaClienteService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PermissaoPessoaService permissaoPessoaService;
    @Autowired
    private  EmailService emailService;
    public Pessoa create(PessoaClienteRequestDTO pessoaClienteRequestDTO){
    Pessoa pessoa =new PessoaClienteRequestDTO().convert(pessoaClienteRequestDTO);
        pessoa.setCreated_at(new Date());
        Pessoa pessoaNovo= pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
        emailService.sendEmailText(pessoaNovo.getEmail(), "Cadastro na loja taajra");
        return pessoaNovo;
    }


}
