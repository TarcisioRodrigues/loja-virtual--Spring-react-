package com.dev.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank(message = "O nome não pode ser vazio")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    private String nome;

    @NotBlank(message = "O CPF não pode ser vazio")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos")
    private String cpf;

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "O endereço não pode ser vazio")
    private String endereco;

    @NotBlank(message = "O CEP não pode ser vazio")
    private String cep;
    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}
