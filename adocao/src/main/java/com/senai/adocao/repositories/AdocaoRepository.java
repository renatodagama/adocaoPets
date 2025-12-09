package com.senai.adocao.repositories;

import com.senai.adocao.models.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {}