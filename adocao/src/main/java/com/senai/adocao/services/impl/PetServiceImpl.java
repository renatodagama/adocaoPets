package com.senai.adocao.services.impl;

import com.senai.adocao.models.Pet;
import com.senai.adocao.repositories.PetRepository;
import com.senai.adocao.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    // MÉTODO LISTAR TODOS - ADICIONADO/CORRIGIDO
    @Override
    public List<Pet> listarTodos() {
        return petRepository.findAll();
    }

    // Outros métodos do CRUD (devem ser mantidos ou adicionados)
    @Override
    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    @Override
    public Optional<Pet> buscarPorId(Long id) {
        return petRepository.findById(id);
    }

    @Override
    public void excluir(Long id) {
        petRepository.deleteById(id);
    }
}