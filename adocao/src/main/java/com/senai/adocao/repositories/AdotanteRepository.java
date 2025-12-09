package com.senai.adocao.repositories;

import com.senai.adocao.models.Adotante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdotanteRepository extends JpaRepository<Adotante, Long> {}