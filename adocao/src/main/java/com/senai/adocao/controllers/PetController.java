package com.senai.adocao.controllers;

import com.senai.adocao.models.Pet;
import com.senai.adocao.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private PetService petService;

    // MÉTODO QUE ESTAVA DANDO ERRO (LINHA 30) - Agora está resolvido
    @GetMapping
    public ResponseEntity<List<Pet>> listarTodos() {
        List<Pet> pets = petService.listarTodos(); // <--- O método agora existe!
        return ResponseEntity.ok(pets);
    }
    
    // Outros Endpoints (Adicionar, Buscar por ID, etc.)
    // ...
}