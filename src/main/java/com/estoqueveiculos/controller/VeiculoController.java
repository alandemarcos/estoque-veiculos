package com.estoqueveiculos.controller;

import com.estoqueveiculos.dto.VeiculoDTO;
import com.estoqueveiculos.model.StatusVeiculo;
import com.estoqueveiculos.service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
@Tag(name = "Veículos", description = "API de gerenciamento de veículos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    @Operation(summary = "Criar veículo")
    public ResponseEntity<VeiculoDTO> criar(@RequestBody VeiculoDTO dto) {
        VeiculoDTO created = veiculoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    @Operation(summary = "Listar veículos com filtros opcionais")
    public ResponseEntity<List<VeiculoDTO>> listar(
            @Parameter(description = "Filtrar por marca") @RequestParam(required = false) String marca,
            @Parameter(description = "Filtrar por modelo") @RequestParam(required = false) String modelo,
            @Parameter(description = "Filtrar por ano") @RequestParam(required = false) Integer ano,
            @Parameter(description = "Filtrar por status") @RequestParam(required = false) StatusVeiculo status,
            @Parameter(description = "Preço mínimo") @RequestParam(required = false) Double precoMin,
            @Parameter(description = "Preço máximo") @RequestParam(required = false) Double precoMax) {
        List<VeiculoDTO> list = veiculoService.listar(marca, modelo, ano, status, precoMin, precoMax);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar veículo por ID")
    public ResponseEntity<VeiculoDTO> buscarPorId(@PathVariable Long id) {
        VeiculoDTO dto = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar veículo")
    public ResponseEntity<VeiculoDTO> atualizar(@PathVariable Long id, @RequestBody VeiculoDTO dto) {
        VeiculoDTO updated = veiculoService.atualizar(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir veículo")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        veiculoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
