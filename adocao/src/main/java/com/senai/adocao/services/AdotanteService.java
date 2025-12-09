package com.senai.adocao.services;

import com.senai.adocao.dtos.AdotanteInputDto;
import com.senai.adocao.exceptions.ResourceNotFoundException;
import com.senai.adocao.models.Adotante;
import com.senai.adocao.repositories.AdotanteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdotanteService {
    @Autowired
    private AdotanteRepository adotanteRepository;

    // Cadastro de adotantes [cite: 10, 42]
    public Adotante salvar(AdotanteInputDto adotanteDto) {
        Adotante adotante = new Adotante();
        BeanUtils.copyProperties(adotanteDto, adotante);
        return adotanteRepository.save(adotante);
    }
    
    public Adotante buscarPorId(Long id) {
        return adotanteRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Adotante", "ID", id));
    }
    
    public List<Adotante> listarTodos() {
        return adotanteRepository.findAll();
    }
}