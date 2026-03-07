package com.estoqueveiculos.controller;

import com.estoqueveiculos.dto.MarcaDTO;
import com.estoqueveiculos.service.MarcaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@RequiredArgsConstructor
@Tag(name = "Marcas", description = "API de gerenciamento de marcas")
public class MarcaController {

    private final MarcaService marcaService;

    @PostMapping
    @Operation(summary = "Criar marca")
    public ResponseEntity<MarcaDTO> criar(@RequestBody MarcaDTO dto) {
        MarcaDTO created = marcaService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    @Operation(summary = "Listar todas as marcas")
    public ResponseEntity<List<MarcaDTO>> listar() {
        return ResponseEntity.ok(marcaService.listar());
    }
}
