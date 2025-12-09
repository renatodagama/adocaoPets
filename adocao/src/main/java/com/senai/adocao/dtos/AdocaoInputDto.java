package com.senai.adocao.dtos;

import lombok.Data; // Inclui Getters, Setters, construtores, etc.
import jakarta.validation.constraints.NotNull; // Para garantir que os IDs não sejam nulos

@Data
public class AdocaoInputDto {

    @NotNull(message = "O ID do Pet é obrigatório.")
    private Long petId;

    @NotNull(message = "O ID do Adotante é obrigatório.")
    private Long adotanteId;

    private String observacoes; // Campo opcional
}