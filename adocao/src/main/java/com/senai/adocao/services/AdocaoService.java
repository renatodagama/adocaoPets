package com.senai.adocao.services;

import com.senai.adocao.dtos.AdocaoInputDto;
import com.senai.adocao.exceptions.ResourceNotFoundException;
import com.senai.adocao.models.Adocao;
import com.senai.adocao.models.Adotante;
import com.senai.adocao.models.Pet;
import com.senai.adocao.repositories.AdocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private PetService petService; // Depende do PetService
    
    @Autowired
    private AdotanteService adotanteService; // Depende do AdotanteService

    // RF03: Processo de Adoção [cite: 49]
    @Transactional // Garante que, se algo falhar, tudo é desfeito (rollback)
    public Adocao registrarAdocao(AdocaoInputDto adocaoDto) {
        
        // 1. Busca e valida Pet
        Pet pet = petService.buscarPorId(adocaoDto.getPetId());
        if (!pet.isDisponivel()) {
             throw new IllegalStateException("Pet ID " + pet.getId() + " já está adotado."); 
        }

        // 2. Busca Adotante
        Adotante adotante = adotanteService.buscarPorId(adocaoDto.getAdotanteId());
        
        // 3. API registra a adoção [cite: 51]
        Adocao adocao = new Adocao();
        adocao.setPet(pet);
        adocao.setAdotante(adotante);
        adocao.setDataAdocao(LocalDate.now()); [cite: 95]
        adocao.setObservacoes(adocaoDto.getObservacoes());
        
        Adocao novaAdocao = adocaoRepository.save(adocao);
        
        // 4. Pet deixa de aparecer como disponível [cite: 52] e a dataAdocao é salva
        petService.marcarIndisponivel(pet);

        return novaAdocao; // Registro armazenado para histórico [cite: 53]
    }
    
    // ... Métodos para listar todas as adoções (GET /api/adocoes) ...
}