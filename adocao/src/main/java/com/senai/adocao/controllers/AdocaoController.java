package com.senai.adocao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.adocao.dtos.AdocaoInputDto;
import com.senai.adocao.models.Adocao;
import com.senai.adocao.services.AdocaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/adocoes") // Base URI: /api/adocoes [cite: 110]
public class AdocaoController {

    @Autowired
    private AdocaoService adocaoService;

    // POST /api/adocoes - RF03: Registrar Adoção [cite: 111, 49]
    @PostMapping
    public ResponseEntity<Adocao> registrarAdocao(@RequestBody @Valid AdocaoInputDto adocaoDto) {
        Adocao novaAdocao = adocaoService.registrarAdocao(adocaoDto);
        return new ResponseEntity<>(novaAdocao, HttpStatus.CREATED);
    }
    
    // ... Implementar GET /api/adocoes [cite: 112] e GET /api/adocoes/{id}[cite: 113]...
}