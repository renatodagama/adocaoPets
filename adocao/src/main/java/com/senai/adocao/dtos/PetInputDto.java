package com.senai.adocao.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PetInputDto {
    @NotBlank(message = "O nome é obrigatório.")
    private String nome;
    @NotBlank(message = "A espécie é obrigatória.")
    private String especie;
    @NotBlank(message = "A raça é obrigatória.")
    private String raca;
    @NotNull(message = "A idade é obrigatória.")
    @Positive(message = "A idade deve ser positiva.")
    private int idade;
    @NotBlank(message = "O porte é obrigatório.")
    private String porte;
    private String descricao;
    private String vacinas;
}