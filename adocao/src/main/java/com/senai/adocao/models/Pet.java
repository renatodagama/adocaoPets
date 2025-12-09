package com.senai.adocao.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String porte;
    private String descricao;
    private String vacinas;

    private boolean disponivel = true; // disponibilidade
    private LocalDate dataEntrada;
    private LocalDate dataAdocao; // Opcional

    // Relacionamento 1:1 com Adoção
    @OneToOne(mappedBy = "pet")
    private Adocao adocao; 
}