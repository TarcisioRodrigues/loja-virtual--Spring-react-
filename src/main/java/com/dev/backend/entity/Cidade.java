package com.dev.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Entity
@Table(name = "cidade")
@Data
public class Cidade {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String nome;
        @Temporal(TemporalType.TIMESTAMP)
        private Date created_at;
        @Temporal(TemporalType.TIMESTAMP)
        private Date updated_at;
}
