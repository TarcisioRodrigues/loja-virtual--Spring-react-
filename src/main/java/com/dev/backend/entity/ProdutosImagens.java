package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "")
@Data
public class ProdutosImagens {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "idProduto")
    private Produto produto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}
