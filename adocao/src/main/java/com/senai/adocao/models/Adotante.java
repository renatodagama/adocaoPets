package com.senai.adocao.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "adotantes")
@Data
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    // Um adotante pode adotar vários pets (Histórico de adoções)
    // Relacionamento 1:N com Adoções
    @OneToMany(mappedBy = "adotante")
    private List<Adocao> petsAdotados;
}