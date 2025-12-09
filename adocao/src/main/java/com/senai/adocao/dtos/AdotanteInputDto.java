package com.senai.adocao.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AdotanteInputDto {
    @NotBlank
    private String nome;
    
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos.")
    private String cpf;
    
    @NotBlank
    private String telefone;
    
    @NotBlank @Email
    private String email;
    
    @NotBlank
    private String endereco;
}