package com.senai.adocao.controllers;

import com.senai.adocao.dtos.AdotanteInputDto;
import com.senai.adocao.models.Adotante;
import com.senai.adocao.services.AdotanteService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/adotantes") // Base URI: /api/adotantes [cite: 106]
public class AdotanteController {

    @Autowired
    private AdotanteService adotanteService;

    // POST /api/adotantes - RF02: Cadastro de adotantes [cite: 107, 10]
    @PostMapping
    public ResponseEntity<Adotante> registrarAdotante(@RequestBody @Valid AdotanteInputDto adotanteDto) {
        Adotante savedAdotante = adotanteService.salvar(adotanteDto);
        return new ResponseEntity<>(savedAdotante, HttpStatus.CREATED);
    }

    // GET /api/adotantes [cite: 108]
    @GetMapping
    public ResponseEntity<List<Adotante>> listarAdotantes() {
        return ResponseEntity.ok(adotanteService.listarTodos());
    }

    // GET /api/adotantes/{id} [cite: 109]
    @GetMapping("/{id}")
    public ResponseEntity<Adotante> buscarAdotantePorId(@PathVariable Long id) {
        return ResponseEntity.ok(adotanteService.buscarPorId(id));
    }
}