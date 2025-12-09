package com.senai.adocao.repositories;

import com.senai.adocao.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PetRepositorie extends JpaRepository<Pet, Long> {
    // Listar pets disponíveis [cite: 27, 105]
    List<Pet> findByDisponivelTrue();

    // Filtrar por espécie, porte, idade (parcial RF01) [cite: 28, 12]
    List<Pet> findByEspecieAndPorteAndIdadeLessThanEqual(String especie, String porte, int maxIdade);
}