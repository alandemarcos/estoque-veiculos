package com.estoqueveiculos.controller;

import com.estoqueveiculos.dto.ModeloDTO;
import com.estoqueveiculos.service.ModeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
@RequiredArgsConstructor
@Tag(name = "Modelos", description = "API de gerenciamento de modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @PostMapping
    @Operation(summary = "Criar modelo")
    public ResponseEntity<ModeloDTO> criar(@RequestBody ModeloDTO dto) {
        ModeloDTO created = modeloService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    @Operation(summary = "Listar todos os modelos")
    public ResponseEntity<List<ModeloDTO>> listar() {
        return ResponseEntity.ok(modeloService.listar());
    }
}
