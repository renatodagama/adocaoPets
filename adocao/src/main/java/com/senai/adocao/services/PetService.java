package com.senai.adocao.services;

import com.senai.adocao.models.Pet;
import java.util.List;
import java.util.Optional;

public interface PetService {

    // MÉTODO LISTAR TODOS - CORREÇÃO OBRIGATÓRIA
    List<Pet> listarTodos(); 
    
    // Outros métodos do CRUD
    Pet salvar(Pet pet);
    Optional<Pet> buscarPorId(Long id);
    void excluir(Long id);
}